using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WanderingAI : MonoBehaviour
{
    public float speed = 3.0f;
    public float obstacleRange = 5.0f;
    private bool _alive;
    
    [SerializeField]
    private GameObject fireballprefab;
    private GameObject fireball;
    void Start()
    {
        _alive = true;
    }

    public void SetAlive(bool alive)
    {
        this._alive = alive;
    }
    
    void Update()
    {
        if (this._alive)
        {
            transform.Translate(0, 0, speed * Time.deltaTime);

            Ray ray = new Ray(transform.position, transform.forward);
            RaycastHit hit;
            if (Physics.SphereCast(ray, 0.75f, out hit))
            {

                PlayerCharacter guy = hit.transform.gameObject.GetComponent<PlayerCharacter>();

                if (guy != null)
                {
                    if (fireball == null)
                    {
                        fireball = Instantiate(fireballprefab) as GameObject;
                        fireball.transform.position = transform.TransformPoint(Vector3.forward * 1.5f);
                        fireball.transform.rotation = transform.rotation;
                    }
                    else if (hit.distance < obstacleRange)
                    {
                        float angle = Random.Range(-110, 110);
                        transform.Rotate(0, angle, 0);
                    }
                }
                if (hit.distance < obstacleRange)
                {
                    float angle = Random.Range(-110, 100);
                    transform.Rotate(0, angle, 0);
                }

            }

        }
    }
}
