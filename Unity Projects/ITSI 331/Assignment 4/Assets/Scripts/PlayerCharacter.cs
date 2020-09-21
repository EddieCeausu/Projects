using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerCharacter : MonoBehaviour
{
    private int health;
    void Start()
    {
        health = 5;
    }

    // Update is called once per frame
    void Update() {
        Debug.Log("Player has " + health + " health remaining");
    }
    public void hurt(int damage)
    {
        health -= damage;
        Debug.Log("Health" + health);
    }
}
