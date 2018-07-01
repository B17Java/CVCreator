;	var API_KEY = 'eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjAzNTU5Y2RiOTQyMGNhNDc5M2I5OWEzZjI4MDllYmJmZWI1MmU3NDNjNTBlOGEyNzVkMzM4MDhkYjNhOTE1MmVmYmExOWY0NWVkYzQ1MWI0In0.eyJhdWQiOiIxMCIsImp0aSI6IjAzNTU5Y2RiOTQyMGNhNDc5M2I5OWEzZjI4MDllYmJmZWI1MmU3NDNjNTBlOGEyNzVkMzM4MDhkYjNhOTE1MmVmYmExOWY0NWVkYzQ1MWI0IiwiaWF0IjoxNTIwNDU0NDY3LCJuYmYiOjE1MjA0NTQ0NjcsImV4cCI6MTgzNjA3MzY2Nywic3ViIjoiOTU4Iiwic2NvcGVzIjpbInVzZXJCYXNlSW5mbyIsInVzZXJEZXRhaWxlZEluZm8iLCJ1c2VyQ291cnNlSW5mbyJdfQ.yDNj9hifaewkV_XFHxIHY30V9yvQpg8XVHsHnFS-Ir3NcMUEyFqg6Yiekqinb05Ee8xO7m1VzAXh68_h9ZCsikVC3EtF17HqhoAP6no1m3E6o2_5Yv1XCDJMsX9Nakun5lWiKVst3m53BsvSkHSXcJ3bEV5-CadhpTsptZx3UDraC2-XvbRSNh-76SBwGA01x500IbrfPl97O0scplh46aOb4czTQFgO9rlriP8rjsiGHEYjaJmYOZbqC8RtlghA7j9X-Wh5mPE7CzVw_TLAr7-bU5lI-BQO27fT-ORIUC9n1cQLvNUK2VdMlTdVFwBoFV9qGxjOGzsMZdAQzBLNYcxLbOCUnnzREQsp3Y7mbKysZWFkYQZmfHxmRU0rHGeiEJNAowaz3DsZXpWZ-ckYm8RqAgKBMUVrhgwsxqi2Smd6RZ6RJYAKen-0ibpczchzCB8EjWUhNlQ_LxqMlrtNNDcBpVxjxAFNNL63rG4uJZ04Ba60gKBeCqlF3bmgbso2zwHtTU1EDZ-35o3Jnxh3BaMiTPWx7KHXndaRZ2sTptYGHBv-88SHJ0vh0XXbvEPGtPgutYA6Yz4YA-p2ISArbEKiWRcDkwcF-iEtFZ6U3rnPzMCigVy2RiGClL8UqCn19w_hhLdIDQM0NmMAc1PgOKC8a9LR57znGipjwWPMoio'; // here you have to put your personal token
var client = new INTITAClient({key: API_KEY}); // creating client instance
var courseId = 1
var moduleId = 1;
//------------About me----------------------------------
  client.getUserDetails(function (error, data) {
     console.log(error, data)
    var nameEl = document.getElementById('name');
    nameEl.innerText = data.firstName + " " + data.secondName;
    var emailEl = document.getElementById('email');
    emailEl.innerText = data.email;
    var phoneEl = document.getElementById('phone');
    phoneEl.innerText = data.phone;
    var avatarEl = document.getElementById('avatar');
    avatarEl.src = data.avatar;
    var adressEl = document.getElementById('adress');
    adressEl.innerText = data.country + ", м. " + data.city;
     var skype = document.getElementById('skype');
    skype.innerText = data.skype;
    var facebook = document.getElementById('facebook');
    facebook.href = data.facebook;
    var namecreate = document.getElementById('namecreate');
    namecreate.innerText = data.firstName + " " + data.secondName;
    var linkedin = document.getElementById('linkedin');
    linkedin.href = data.linkedin;
    var twitter = document.getElementById('twitter');
    twitter.href = data.linkedin;
    var trainer = document.getElementById('trainer');
    trainer.innerText = data.trainers[0].firstName + " " + data.trainers[0].secondName;
  });

client.getUserCoursesAndModules(function (error, data) {
     console.log(error, data)

    document.getElementById('courses').innerText = data.courses[0].title;
    data.courses.forEach(function (element) {

//------------------<getCourseModules>-------------------
        client.getCourseModules(element.id,function (error,data) {
             console.log(modules);
            var modules = document.getElementById("modules");//4errors
            data.forEach(function (module) {
                var div = document.createElement("div");
                div.innerText = module.title;
                modules.appendChild(div);
                var ul = document.createElement("ul");
                div.appendChild(ul);

//-------------------<getModuleLectures>-------------------------------------

                client.getModuleLectures(module.id,function (error,data) {
                    // console.log(data);
                    div.onclick = function(){//warning 5
                        ul.classList.toggle('visible');
                    };
                    data.forEach(function (variable) {
                        var li = document.createElement("li");
                        li.innerText = variable.title;
                        ul.appendChild(li);
                    });
                });
            });
        });
    });
});
  client.getCourseInfo(courseId, function (error, data) {
     console.log(error, data)
     });
//-----Info2---------------------------------------------
client.getModuleInfo(moduleId, function (error, data) {
    // console.log(error, data)




    //-------------------------------------
    var el;
    var arr = data.what_you_learn.split(';');
    var container=document.createElement('ol');
    for (var i = 0; i < arr.length-1; i++) {
        el=document.createElement('li');
        el.innerText=arr[i];
        container.appendChild(el);
    }
    document.getElementById('inform');
    container= inform.appendChild(container);
//    ---------
    var who_el;
    var arr_who = data.for_whom.split(';');
    var container2=document.createElement('ol');
    for (var i = 0; i < arr_who.length-1; i++) {
        who_el=document.createElement('li');
        who_el.innerText=arr_who[i];
        container2.appendChild(who_el);
    }
    document.getElementById('who_inform');
    container2= who_inform.appendChild(container2);
  //-----------------------------------------
    var media_c;
    var arr_media = data.what_you_get.split(';');
    var container3=document.createElement('ol');
    for (var i = 0; i < arr_media.length-1; i++) {
        media_c=document.createElement('li');
        media_c.innerText=arr_media[i];
        container3.appendChild(media_c);
    }
    document.getElementById('media');
    container3= media.appendChild(container3);
});




  //*-------------------------------------------------------
  client.getCourseModules(courseId, function (error, data) {
    // console.log(error, data);
  });
  client.getCourseTags(courseId, function(error, data) {
    // console.log(error, data);
  });
  client.getModuleTags(moduleId, function(error, data) {
    // console.log(error, data);
  });
  client.getModuleLectures(moduleId, function(error, data) {
    // console.log(error, data);

  });

