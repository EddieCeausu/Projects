using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{
    public float speed = 5f;

    public bool on = true;
    public int score = 0;
    void Start()
    {
       GetComponent<Rigidbody2D>().AddForce(Vector2.down * 500);
    }

    // Update is called once per frame
    void Update()
    {
        if(!on) {
            Respawn();
        }
    }
     public void Respawn() {
        transform.position = Vector2.zero;
    }
    void OnCollisionEnter2D(Collision2D other) {
        if(other.transform.CompareTag("Tile")) {
            Destroy (other.gameObject);
            score++;
        }
    }
    
}
