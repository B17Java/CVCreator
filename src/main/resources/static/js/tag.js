$(document).ready(function() {
    $('.js-google-login .js-toggle-signup-mode').on('click', function(e){
      e.preventDefault();
      $('.js-google-login').hide();
      $('.js-classic-signup').fadeIn(500);
    });

    $('.js-classic-signup .js-toggle-signup-mode').on('click', function(e){
      e.preventDefault();
      $('.js-classic-signup').hide();
      $('.js-google-login').fadeIn(500);
    });

    var skillsSource = ["Java","MySQL",  "CSS", "HTML", "Git", "JavaScript", "Linux","PHP", "jQuery", "SQL",  "C#", "XML", "C++", "Python", "OOP/OOD", "PostgreSQL", "MongoDB", "Spring", "Hibernate", "CSS3", "HTML5", "MVC", "Oracle", "ASP.NET", "Maven", "Android", "WPF", "JSON", "WCF", "AJAX", ".NET", "Jira", "Django", "Scrum", "Windows", "JSP", "Yii", "Redis", "JDBC", "SQLite", "Agile", "Ruby", "TDD", "JUnit", "REST API", "STL", "Qt", "Bootstrap", "ADO.NET", "Tomcat", "Delphi", "LINQ", "iOS", "WinForms", "Selenium", "Design Patterns", "Angular.js", "Eclipse", "Apache", "Mercurial", "Frontend", "Entity Framework", "Node.js", "Photoshop", "T-SQL", "Objective-C", "JPA", "Nginx", "Multithreading", "Servlets", "Redmine", "SOAP", "UML", "TFS", "Backbone.js", "Jenkins", "Perl", "Ruby on Rails", "Ant", "Subversion", "Wordpress", "JSF", "CoffeeScript", "Joomla", "PL/SQL", "C/C++", "FreeBSD", "SASS", "LESS", "bash", "Android SDK", "Drupal", "EJB", "GWT", "Smarty", "Scala", "CodeIgniter", "XSLT", "Quality Assurance (QA)", "OpenGL", "Flask", "OOD", "Swing", "Symfony", "Twitter Bootstrap", "Ubuntu", "Zend Framework (ZF)", "Java EE", "Silverlight", "Magento", "Memcached", "\u0421++", "ExtJS", "JMS", "Illustrator", "Sphinx", "Boost", "MS SQL Server", "BDD", "Patterns", "NodeJS", "Unix", "User Interface (UI)", "Unity3D", "TCP/IP", "CI", "NoSQL", "RabbitMQ", "JBoss", "Java Core", "WinAPI", "TestNG", "Kohana", "TeamCity", "JSTL", "UIKit", "HAML", "Flash", "NetBeans", "AWS", "C (plain)", "Product management", "RSpec", "Kanban", "Groovy", "Confluence", "MFC", "NHibernate", "HTTP", "Spring MVC", "XPath", "Mockito", "PHPUnit", "Mantis", "XAML", "Struts", "Memcache", "Embedded", "Algorithms", "Cocoa", "Adobe Photoshop", "IIS", "Selenium IDE", "Firebird", "CoreData", "Flex", "RoR", "English", "NUnit", "Visual Studio", "Knockout", "SOA", "Networking", "Perforce", "Lua", "Xcode", "LAMP", "Firebug", "SSIS", "Tornado", "\u0421#", "CakePHP", "Highload", "RequireJS", "Microsoft SQL Server", "Doctrine", "SEO", "Windows Phone", "MVVM", "Erlang", "JMeter", "IntelliJ IDEA", "User Experience (UX)", "Debian", "Azure", "COM", "DDD", "MapKit", "Windows Forms", "TestComplete", "Cocoa Touch", "Foundation", "XP", "CVS", "Twig", "MacOS", "SoapUI", "Prototype", "CentOS", "Axure", "Mongo", "Pascal", "GCD", "GUI", "Cucumber", "SSRS", "Test driven development (TDD)", "ActionScript", "SOLID", "Manual Testing (QA)", "Hadoop", "Entity", "DNS", "EntityFramework", "Sinatra", "Cassandra", "CMS", "Solr", "Grunt", "Project Management", "JAXB", "CRM", "Symfony 2", "TestRail", "Celery", "regression", "Knockout.js", "DHCP", "ETL", "DevExpress", "Automation", "Jetty", "CouchDB", "Stylus", "Embedded C", "Automated Testing (QA)", "Web Development", "JAX-RS", "Bugzilla", "ORM", "ASP", "SCSS", "WebServices", "ZF", "Servlet", "Java SE", "Threads", "Microsoft Office", "IDEA", "SDLC", "Facebook API", "iPhone", "Jade", "Shell", "Bitrix", "Selenium WebDriver", "ARM", "Adobe Illustrator", "Visual Basic (VB)", "Capybara", "Vaadin", "DB2", "Matlab", "VirtualBox", "Security", "Gradle", "Underscore.js", "Laravel", "XSD", "VMware", "Glassfish", "ActionScript3 (AS3)", "PHP5", "RUP", "Waterfall", "MyBatis", "CoreLocation", "Objective C", "Assembler", "Nagios", "Cocos2d", "Zabbix", "WinRT", "usability", "Grails", "SVG", "SharePoint", "R (language)", "Continuous Integration", "DirectX", "JAX-WS", "OpenCV", "Cisco", "Regression Testing", "Win32", "D (language)", "Swift", "Leaflet", "Open Source", "GIS", "Haskell"]

    var skillsCloud = [];
    for (var i = 0; i < 5; i++) {
        skillsCloud.push('<a href="#" class="label label-cloud">' + skillsSource[i] + '</a>');
    }
    $('.skills-cloud').html(skillsCloud.join(""));

    // Typeahead для скиллов
    $('#skills').tagsinput({
      
      typeahead: {
        source: skillsSource
      }
    });

    $('#skills').on('itemAdded', function(event) {
      var currentSkills = $('.skills-cloud .label').map(function(){ return $(this).text() }).get();

      var skillsVal = $('#skills').tagsinput('items');

      var randomSkill = skillsSource[Math.floor(Math.random() * skillsSource.length)];

      // Если уже айтем есть в форме, удаляем
      if($.inArray(event.item, currentSkills) != -1) {
        $('.skills-cloud .label:contains(' + event.item + ')').remove();
      }

      // Добавляем новые саджешшны
      if(currentSkills.length < 5 && randomSkill != undefined) {
        $('.skills-cloud').append('<a href="#" class="label label-cloud">' + randomSkill + '</a> ')
      }

    });

    // Подстановка предлагаемого тега в tags-input
    function addItem(item, id) {
      var currentItem = item;
      var itemsInput = $(id);
      itemsInput.tagsinput('add', currentItem);
    }

    $('.skills-cloud').on('click', '.label-cloud', function(){
      var value = $(this).html();
      addItem(value, skills);
      
      var randomSkill = skillsSource[Math.floor(Math.random() * skillsSource.length)];

      // Берем массив элементов в облаке
      var currentSkills = $('.skills-cloud .label').map(function(){ return $(this).text() }).get();

      // Элементы в форме
      var skillsVal = $('#skills').tagsinput('items');

      var _this = $(this);

      // По клику на элемент, добавится еще один.
      // Чтобы не было повторений, проверяем, нет ли его в форме или в облаке
      if($.inArray(randomSkill, currentSkills) != -1 || $.inArray(randomSkill, skillsVal) != -1) {
        _this.remove();
      }

      else {
        _this.remove();
        $('.skills-cloud').append('<a href="#" class="label label-cloud">' + randomSkill + '</a> ')
      }

      return false;
    });

    // Исходные саджешшны
    var initialSkills = $('.skills-cloud .label').map(function(){
      return $(this).text()
    }).get();

    // При удалении возвращаем саджешны обратно в облако
    $('#skills').on('itemRemoved', function(event) {
      var foundSkills = $.inArray(event.item, initialSkills) > -1;
      if(foundSkills && event.item !== undefined) {
        $('.skills-cloud').append('<a href="#" class="label label-cloud">' + event.item + '</a> ');
      }
    });
});