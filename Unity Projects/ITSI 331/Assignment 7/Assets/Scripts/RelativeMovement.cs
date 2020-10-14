using System.Collections;
using System.Collections.Generic;
using UnityEngine;
[RequireComponent(typeof(CharacterController))]
public class RelativeMovement : MonoBehaviour
{
    [SerializeField]
    private Transform _camera;
    private Animator animator;
    private CharacterController _charController;
    public float rotationSpeed = 15.0f;
    public float moveSpeed = 6.0f;
    public float jumpSpeed = 15.0f;
    public float gravity = -9.8f;
    public float terminalVelocity = -10.0f;
    public float minFall = -1.5f;
    private float _vertSpeed;
    // private ControllerColliderHit _contact;

    void Start()
    {
        _charController = GetComponent<CharacterController>();
        this.animator = GetComponent<Animator>();
        _vertSpeed = minFall;
    }

    void Update()
    {
        Vector3 movement = Vector3.zero;

        float xInput = Input.GetAxis("Horizontal");
        float yInput = Input.GetAxis("Vertical");
        // RaycastHit hit;
        // bool hitGround = false;
        // if (_vertSpeed < 0 && Physics.Raycast(transform.position, Vector3.down, out hit))
        //     hitGround = hit.distance <= (_charController.height + _charController.radius) / 1.9f;

        if (xInput != 0 || yInput != 0)
        {
            movement.x = xInput;
            movement.z = yInput;

            Quaternion tmp = _camera.rotation;
            _camera.eulerAngles = new Vector3(0, _camera.eulerAngles.y, 0);
            movement = _camera.TransformDirection(movement);
            _camera.rotation = tmp;

            Quaternion direction = Quaternion.LookRotation(movement);
            transform.rotation = Quaternion.Lerp(transform.rotation, direction, rotationSpeed * Time.deltaTime);

            movement *= moveSpeed;
            movement = Vector3.ClampMagnitude(movement, moveSpeed);
        }
        
        // if (hitGround)
        if (_charController.isGrounded)
        {
            this.animator.SetBool("jump", false);
            if (Input.GetButtonDown("Jump")){
                this._vertSpeed = jumpSpeed;
                this.animator.SetBool("jump", true);
            } else
                _vertSpeed = minFall;
        }
        else
        {
            _vertSpeed += gravity * 5 * Time.deltaTime;
            if (_vertSpeed < terminalVelocity)
                _vertSpeed = terminalVelocity;
        }
        // if (_charController.isGrounded) {
        //     if(Vector3.Dot(movement, _contact.normal) < 0)
        //         movement = _contact.normal * moveSpeed;
        //     else 
        //         movement += _contact.normal * moveSpeed;
        // }
        this.animator.SetFloat("speed", movement.sqrMagnitude);
        movement.y = _vertSpeed;
        movement *= Time.deltaTime;
        _charController.Move(movement);

    }
    // void OnControllerColliderHit(ControllerColliderHit hit) {
    //     _contact = hit;
    // }
}
