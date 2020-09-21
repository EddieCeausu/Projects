using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SceneControllerScript : MonoBehaviour
{
    void Start()
    {
        for (int i = 0; i < 10; i++)
        {
            SpawnEnemy();
        }
    }
    [SerializeField]
    private GameObject enemyPrefab;
    private GameObject enemy;

    void Update()
    {
        int respawns = GameObject.FindGameObjectsWithTag("Respawn").Length;
        if (respawns < 5)
        {
            for (int i = 0; i < 5; i++)
            {
                SpawnEnemy();
            }
        }
    }
    public void SpawnEnemy()
    {
        enemy = Instantiate(enemyPrefab);
        enemy.transform.position = new Vector3(Random.Range(-50, 50), 1.5f, Random.Range(-50, 50));
        float angle = Random.Range(0, 360);
        enemy.transform.Rotate(0, angle, 0);
    }
}
