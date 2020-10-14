using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Paddle : MonoBehaviour
{
    public float speed;
    private float leftEdge = -8.4f;
    private float rightEdge = 8.4f;
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        float horizontal = Input.GetAxis("Horizontal");
        transform.Translate(Vector2.right * horizontal * Time.deltaTime * speed);

        if (transform.position.x < leftEdge)
            transform.position = new Vector2(leftEdge, transform.position.y);
        if (transform.position.x > rightEdge)
            transform.position = new Vector2(rightEdge, transform.position.y);
    }
}
