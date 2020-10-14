using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class characterController : MonoBehaviour
{
    public float speed = 50f;
    public float sprint = 2f;
    public float dash = 30f;
    public float jump = 10;
    public bool isGrounded;
    public bool isJumping;

    private Rigidbody2D body;
    public Animator animator;
    void Start()
    {
        this.body = GetComponent<Rigidbody2D>();
        this.animator = GetComponent<Animator>();
        isGrounded = false;
    }

    // Update is called once per frame
    void Update()
    {
        float deltaX = Input.GetAxis("Horizontal") * speed * Time.deltaTime;
        Vector2 movement = new Vector2(deltaX, body.velocity.y);
        body.velocity = movement;

        // animation
        animator.SetFloat("speed", Mathf.Abs(deltaX));
        

        //movement based on x position
        if (!Mathf.Approximately(deltaX, 0))
            transform.localScale = new Vector3(Mathf.Sign(deltaX) * 0.1f, 0.1f, 1);
        // when jumping set state to jumping and trigger jump;
        if(Input.GetKeyDown(KeyCode.Space) && isGrounded){
            this.body.AddForce(Vector2.up * jump, ForceMode2D.Impulse);
            animator.SetTrigger("jump");
            animator.SetBool("isJumping", true);
        }
        if(Input.GetKeyDown(KeyCode.LeftShift))
            this.speed *= sprint;
        else 
            this.speed = 50f;
        
        if(isGrounded) {
            isJumping = false;
            animator.SetBool("isJumping", false);
        } 
    }

}
