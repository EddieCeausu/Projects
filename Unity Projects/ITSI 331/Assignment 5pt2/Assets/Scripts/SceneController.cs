using System.Collections;
using System.Collections.Generic;

using UnityEngine;

public class SceneController : MonoBehaviour
{
    public Ball ball;
    public Paddle paddle;
    public Tile tilePrefab;
    public Tile[,] tiles;
    public TextMesh scoreLabel;
    public int scoreTemp = 0;
    public GameObject restart;
    void Start()
    {
        ball = Instantiate(ball);
        paddle = Instantiate(paddle) as Paddle;
        tiles = new Tile[4, 5];
        spawnTiles();
        restart.SetActive(false);
    }

    // Update is called once per frame
    void Update()
    {
        ball.transform.Translate(Vector2.one.normalized * ball.speed * Time.deltaTime);
        scoreLabel.text = "Score: " + ball.score;
        if(ball.score == 20) {
            stopGame();
            Destroy(scoreLabel);
            restart.SetActive(true);
        }
        
    }
/*
    public void spawnTiles returns none
    initX[] contains all the X postions 
    initY[] contains all the Y positions
    for loop creates a 2D array of tiles with n = X and i = Y
*/
    public void spawnTiles() {
        float[] initX = { -7.0f, -3.5f, 0f, 3.5f, 7f};
        float[] initY = { 4.0f, 3.0f, 2.0f, 1.0f };

        for (int n = 0; n < 4; n++) {
            for (int i = 0; i < 5; i++) {
                tiles[n, i] = Instantiate(tilePrefab) as Tile;
                tiles[n, i].transform.position = new Vector3(initX[i], initY[n], 1.0f);

                // Debug.Log("Current Position: " + tiles[n, i].transform.position);
                // Debug.Log("n: " + n + "i: " + i);
            }
        }
    }
    void stopGame() {
        ball.on = false;
    }
}
