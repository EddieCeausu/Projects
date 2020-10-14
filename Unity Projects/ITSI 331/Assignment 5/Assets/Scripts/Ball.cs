using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Ball : MonoBehaviour
{
    public float speed = 5.0f;
    public float radius;
    Vector2 direction;
    void Start()
    {
        // direction = Vector2.one.normalized;
        // radius = transform.localScale.x / 2;
    }

    // Update is called once per frame
    void Update()
    {
        
    }
    public void Respawn() {
        transform.position = Vector3.zero;
    }
}
