using System.Collections;
using System.Collections.Generic;
using UnityEngine.SceneManagement;
using UnityEngine;

public class UIButton : MonoBehaviour
{
    [SerializeField] private GameObject targetObject;
    [SerializeField] private string targetMessage;
    public Color highlight = Color.cyan;
    
    public void OnMouseEnter() {
        SpriteRenderer sprite = GetComponent<SpriteRenderer>();
        if(sprite != null) 
            sprite.color = highlight;
    }   
    public void OnMouseExit() {
        SpriteRenderer sprite = GetComponent<SpriteRenderer>();
        if(sprite != null) 
            sprite.color = Color.white;
    }
    public void onMouseDown() {
        transform.localScale = new Vector3(2f,2f,2f);
    }
    public void onMouseUp() {
        transform.localScale = Vector3.one;
        SceneManager.LoadScene("SampleScene");
    }

}
