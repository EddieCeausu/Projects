using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class NewBehaviourScript : MonoBehaviour
{
    int frame;
    // Start is called before the first frame update
    void Start()
    {
      Debug.Log("This is the start of the script");
      frame = 0;
    }

    // Update is called once per frame
    void Update()
    {
      frame++;
      Debug.Log("This is the script updated once per frame");
      Debug.Log("Frame: " + frame);
      

    }
}
