using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[RequireComponent(typeof(CharacterController))]
[AddComponentMenu("Control Script/FPS Input")]
public class FPSInput : MonoBehaviour {

    public float speed = 6.0f;
    public float gravity = -9.8f;
    private CharacterController _characterController;
    // // Jump Variables
    // public Vector3 jump;
    // public float jumpForce = 2.0f;
    // Rigidbody rb; 
    // public bool isGrounded;
    
    // void OnCollisionStay() {
    //     isGrounded = true;
    // }
    void Start() {
        _characterController = GetComponent<CharacterController>();
        // rb = GetComponent<Rigidbody>();
    }

    // Update is called once per frame
    void Update() {
        float deltaX = Input.GetAxis("Horizontal") * speed;
        float deltaZ = Input.GetAxis("Vertical") * speed;
        Vector3 movement = new Vector3(deltaX, 0, deltaZ);
        movement = Vector3.ClampMagnitude(movement, speed);

        movement.y = gravity;
        movement *= Time.deltaTime;
        movement = transform.TransformDirection(movement);
        _characterController.Move(movement);
        // Jump Code Test
        // if(Input.GetKeyDown(KeyCode.Space)){
        //     rb.AddForce(jump * jumpForce, ForceMode.Impulse);
        //     isGrounded = false;
        // }
        // Sprint Code Test
        // if(Input.GetKeyDown(KeyCode.LeftShift) || Input.GetKeyDown(KeyCode.RightShift)) {
        //     speed = 8.0f;
        //     Debug.Log("Sprint: " + speed);
        // }
        // speed = 6.0f;
        // Debug.Log("Speed: " + speed);
    }
}
