import os
import random
test = '''<article class="item thumb span-1">
<h2>The Pursuit</h2><a href="images/fulls/inventory/inventory-11.jpg" class="image"><img
src="images/fulls/inventory/inventory-12.jpg" alt=""></a>
</article>'''

text = '''
 <section id="main">
            <!-- Items  Top row-->
            <div class="items">
               <div class="item intro span-1">
                  <h1>Inventory</h1>
               </div>
               <article class="item thumb span-1">
                  <h2>Winchester Model 12</h2>
                  <a href="images/fulls/inventory/inventory-1.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-1.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Winchester Model 12</h2>
                  <a href="images/fulls/inventory/inventory-2.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-2.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Winchester model 12</h2>
                  <a href="images/fulls/inventory/inventory-3.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-3.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Winchester model 12</h2>
                  <a href="images/fulls/inventory/inventory-4.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-4.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Winchester model 42</h2>
                  <a href="images/fulls/inventory/inventory-5.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-5.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Remington</h2>
                  <a href="images/fulls/inventory/inventory-6.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-6.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-7.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-7.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-8.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-8.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-9.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-9.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-10.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-10.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-11.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-11.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-12.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-12.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-13.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-13.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-14.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-14.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-15.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-15.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-16.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-16.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-17.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-17.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-18.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-18.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-19.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-19.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-20.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-20.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-21.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-21.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-22.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-22.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-23.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-23.jpg" alt=""></a>
               </article>
            </div>
            <!-- Items Bottom Row-->
            <div class="items">
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-24.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-24.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-25.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-25.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-26.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-26.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-27.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-27.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-28.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-28.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-29.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-29.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-30.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-30.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-31.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-31.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-32.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-32.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-33.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-33.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-34.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-34.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-35.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-35.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-36.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-36.jpg" alt=""></a>
               </article>
               <article class="item thumb span-3">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-37jpg" class="image"><img
                     src="images/fulls/inventory/inventory-37.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-38.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-38.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-39.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-39.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-40.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-40.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-41.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-41.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-42.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-42.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-43.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-43.jpg" alt=""></a>
               </article>
               <article class="item thumb span-2">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-44.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-44.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-45.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-45.jpg" alt=""></a>
               </article>
               <article class="item thumb span-1">
                  <h2>Lorem Ipsum</h2>
                  <a href="images/fulls/inventory/inventory-46.jpg" class="image"><img
                     src="images/fulls/inventory/inventory-46.jpg" alt=""></a>
               </article>
            </div>
         </section>
'''

indexes = [ 96,
  160,
  289,
  354,
  481,
  546,
  678,
  743,
  878,
  943,
  1073,
  1138,
  1266,
  1331,
  1468,
  1533,
  1658,
  1723,
  1860,
  1924,
  2053,
  2118,
  2245,
  2310,
  2442,
  2507,
  2642,
  2707,
  2837,
  2902,
  3030,
  3095,
  3232,
  3297,
  3422,
  3487 ]
ind = range(29,47)
print ind
j = 0
x = 0
for i in xrange(len(text)):
    try:
        if text[i:i+16] == 'item thumb span-':
            print 'it worked'
            text = text[:i] + 'item thumb span-' + str(random.randint(1,3)) + text[i+17:]
    except Exception as e:
        print 'it failed'
        print e

print text