using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Fireball : MonoBehaviour
{
    public float speed = 10.0f;
    public int damage = 1;
    void Start()
    {
       transform.Translate(0,0, speed * Time.deltaTime); 
    }

    // Update is called once per frame
    void OnTriggerEnter(Collider other) {
        PlayerCharacter player = other.GetComponent<PlayerCharacter>();
        if(player != null) {
            player.hurt(this.damage);
        }
        Destroy(this.gameObject);
    }
}
