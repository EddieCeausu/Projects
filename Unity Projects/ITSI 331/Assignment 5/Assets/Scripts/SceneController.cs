using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System;
public class SceneController : MonoBehaviour
{
    public Ball ball;
    public Paddle paddle;
    public Tile tilePrefab;
    public Tile[,] tiles;


    
    // Start is called before the first frame update
    void Start()
    {
        ball = Instantiate(ball) as Ball;
        paddle = Instantiate(paddle) as Paddle;
        paddle.transform.position = new Vector3(0.0f, -4.5f, 1.0f);
        tiles = new Tile[4,6]; // 4 rows 5 columns of tiles
        spawnTiles();
    }

    // Update is called once per frame
    void Update()
    {
        ball.transform.Translate(Vector2.one.normalized * ball.speed * Time.deltaTime);
    }
    /*

    public void spawnTiles returns none
    initX[] contains all the X postions 
    initY[] contains all the Y positions
    for loop creates a 2D array of tiles with n = X and i = Y

    */
    public void spawnTiles() {
        float[] initX = { -7.0f, -4.5f, -2.0f, 0.5f, 3.0f, 5.5f };
        float[] initY = { 4.0f, 3.0f, 2.0f, 1.0f };

        for (int n = 0; n < 4; n++) {
            for (int i = 0; i < 6; i++) {
                tiles[n, i] = Instantiate(tilePrefab) as Tile;
                tiles[n, i].transform.position = new Vector3(initX[i], initY[n], 1.0f);

                // Debug.Log("Current Position: " + tiles[n, i].transform.position);
                // Debug.Log("n: " + n + "i: " + i);

                if (i == 6) {
                    i = 0;
                    n++;
                }
            }
        }

    }
}
