$(function(){

  // Submit form by pressing Cmd/Ctrl + Enter
  // (when focused on <textarea>)
  if ($('textarea.keysubmit').length) {
    $('textarea.keysubmit').keydown(function (e) {
      if (e.metaKey && e.keyCode == 13) {
        $(this).parents('form').submit();
      }
    });
  }


  // Initialize tooltip
  if($('[data-toggle=tooltip]').length) {
    $('[data-toggle=tooltip]').tooltip({
      container: 'body' // tricky protection from overflow: hidden
    });
  }


  if($('.icon-favorite').length) {
    var request; 

    $(document).on('click', '.icon-favorite', function(event){

      if(request) {
        request.abort()
      }

      var link = $(this);
      var shortcode = link.data('shortcode');
      var token  = link.data('token');

      if(link.hasClass('icon-favorite-inactive')) {
        url = '/bookmark/';
        link.removeClass('icon-favorite-inactive').addClass('icon-favorite-active');
        link.find('.glyphicon').removeClass('glyphicon-star-empty').addClass('glyphicon-star');
        link.prop('title', link.data('title-remove'));
      }

      else if(link.hasClass('icon-favorite-active')) {
        url = '/delete_bookmark/';
        link.removeClass('icon-favorite-active').addClass('icon-favorite-inactive');
        link.find('.glyphicon').removeClass('glyphicon-star').addClass('glyphicon-star-empty');
        link.prop('title', link.data('title-add'));
      }

      request = $.ajax({
        url: '/q/' + shortcode + url,
        type: 'post',
        data: {
          csrfmiddlewaretoken: token
        }
      });

      request.fail(function (jqXHR, textStatus, errorThrown){
          console.error("The following error occured: " + textStatus, errorThrown);
      });

      event.preventDefault();
    });
  }

});
