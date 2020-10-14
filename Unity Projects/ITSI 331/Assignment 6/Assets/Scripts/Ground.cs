using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ground : MonoBehaviour
{
    GameObject player;
    void Start()
    {
        player = gameObject.transform.parent.gameObject;   
    }

    private void OnCollisionEnter2D(Collision2D col) {
        if (col.collider.tag == "Floor")
            player.GetComponent<characterController>().isGrounded = true;
            
    }
    private void OnCollisionExit2D(Collision2D col) {
        if (col.collider.tag == "Floor")
            player.GetComponent<characterController>().isGrounded = false;
        
    }
}
