using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OrbitingCamera : MonoBehaviour
{
    [SerializeField]
    private Transform player;
    public float rotationSpeed = 1.5f;
    private Vector3 offset;
    private float rotationY;
    void Start()
    {
        this.offset = this.player.transform.position - this.transform.position;
        this.rotationY = this.transform.eulerAngles.y;
    }

    // Update is called once per frame
    void LateUpdate()
    {
        float xInput = Input.GetAxis("Horizontal");
        if (xInput != 0) {
            this.rotationY += xInput * this.rotationSpeed;
        } else {
            this.rotationY += Input.GetAxis("Mouse X") * this.rotationSpeed * 3;
        }
        Quaternion rotation = Quaternion.Euler(0, this.rotationY, 0);
        transform.position = this.player.position - (rotation * offset);
        transform.LookAt(this.player);
    }
}
