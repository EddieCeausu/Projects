using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ladder : MonoBehaviour
{
    public float climbSpeed = 6f;
    void OnTriggerStay2D(Collider2D collider)
    {
        if (collider.gameObject.CompareTag("Player"))
        {
            if (Input.GetKey(KeyCode.W))
                collider.GetComponent<Rigidbody2D>().velocity = new Vector2(0, climbSpeed);
            else if (Input.GetKey(KeyCode.S))
                collider.GetComponent<Rigidbody2D>().velocity = new Vector2(0, -climbSpeed);
            else
                collider.GetComponent<Rigidbody2D>().velocity = new Vector2(0, 0);
        }
    }
}
