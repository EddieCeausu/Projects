
# .RDP file to modify
$fileLocal = ""

<#
    .SYNOPSIS
    - This script is attempting to grab the ouput of the mstsc /l command ->
        Detect the final two monitors to utilize as the RDP monitors ->
        Then have to modify an existing RDP file at the "selectedmonitors:s:x,y" to the correct integers.
    - Expected output:
        screen mode id:i:2
        use multimon:i:1
        selectedmonitors:s:x,y

    .PARAMETER commandOutput 
     Output of MSTSC /l
    .Parameter monID
     Where in the arary the monitor is located
    
    @returns the substring of the selected ID in the Remote desktop connection. 
 
    Microsoft Mstsc /l does not return a string array. The output must be grabbed via a ComObject. \
    Since it is a micreosoft forms object, the window can be copied to retrieve the data. 
    
    Sample output of copied mstsc /l:
        [Window Title]
        Remote Desktop Connection

        [Content]
        3: 1920 x 1080; (1920, 0, 3839, 1079)
        4: 1920 x 1080; (0, 0, 1919, 1079)


        [OK]
#>


$wshell = New-Object -ComObject wscript.shell;   # Create a new ComObject in a new shell instance
mstsc /l                                         # Run command
Start-Sleep 1                                    # Wait for command to appear on desktop
$wshell.AppActivate('Remote Desktop Connection') # Bring window into focus
Start-Sleep 1                                    # Safety Wait
Add-Type -AssemblyName System.Windows.Forms       
[System.Windows.Forms.SendKeys]::SendWait('^c'); # Copy window in focus
Start-Sleep 1                                    # Wait for copy to complete
Add-Type -AssemblyName System.Windows.Forms
[System.Windows.Forms.SendKeys]::SendWait('~');  # Close Window


$tmp = Get-Clipboard | Select-String -Pattern "([0-9]):" # Save a substring using regex; everything before the ":" for each line

$output = [string[]]$tmp.Matches.Groups[1,3,5].Value; # From the substring save the odd numbered values. 

Write-Output($tmp, $output)

# Final Monitor
$LastMonitor = $output[$output.Count - 1]

# Second to last monitor (middle monitor)
$SecondLastMonitor = $output[$output.Count - 2]

# Visual Validation
Write-Output ("Final: " + $LastMonitor + " middle: " + $SecondLastMonitor)

# create the correct addition for the .RDP file
$selectedmonitors = "selectedmonitors:s:"+ $SecondLastMonitor + "," + $LastMonitor

# Change the conent in the RDP file
# Search the document for 'selectedmonitors:s:x,y' via regex and replace with new output
(Get-Content -Path $fileLocal) | ForEach-Object {
     $_ -Replace 'selectedmonitors:s:[1-9],[1-9]', (
         $selectedmonitors
         )
        } | Set-Content -Path $fileLocal

