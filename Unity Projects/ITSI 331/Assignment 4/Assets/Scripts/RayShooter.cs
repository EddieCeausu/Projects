﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RayShooter : MonoBehaviour
{
    private Camera _camera;
    void Start()
    {
        this._camera = this.GetComponent<Camera>();
        
    }

    private void OnGUI() {
        int size = 20;
        float posX = _camera.pixelWidth/2 - size/4;
        float posY = _camera.pixelHeight/2 - size/4;
        GUI.Label(new Rect(posX, posY, size, size), "*");
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetMouseButtonDown(0)) {
            Vector3 point = new Vector3(_camera.pixelWidth/2, _camera.pixelHeight/2, 0);
            Ray ray  = _camera.ScreenPointToRay(point);
            RaycastHit hit;
            if (Physics.Raycast(ray, out hit)) {
                GameObject gameObject = hit.transform.gameObject;
                ReactiveTarget target = gameObject.GetComponent<ReactiveTarget>();
                if(target != null) {
                    target.ReactToHit();
                }
                else {
                    StartCoroutine(SphereIndicator(hit.point));
                    }
            }

        }
    }

    private IEnumerator SphereIndicator(Vector3 hitmarker) {
        GameObject sphere = GameObject.CreatePrimitive(PrimitiveType.Sphere);
        sphere.transform.position = hitmarker;

        yield return new WaitForSeconds(0.1f);

        Destroy(sphere);

    }
}
