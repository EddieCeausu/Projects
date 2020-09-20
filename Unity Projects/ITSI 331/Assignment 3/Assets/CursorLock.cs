using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CursorLock : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Cursor.visible = true;
        Cursor.lockState = CursorLockMode.Locked;
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetKey(KeyCode.K)) {
            if(Cursor.visible == true)
                Cursor.visible = false;
            else
                Cursor.visible = true;
            if(Cursor.lockState == CursorLockMode.Locked)
                Cursor.lockState = CursorLockMode.Confined;
            else 
                Cursor.lockState = CursorLockMode.Locked;
        }
        // Cursor.lockState = CursorLockMode.Confined;
    }

}
