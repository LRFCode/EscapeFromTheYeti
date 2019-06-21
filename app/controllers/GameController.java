package controllers;

import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.helper.CSRF;

public class GameController extends Controller
{
    public Result getGameStart(Http.Request request)
    {
        Html csrfToken = getCSRFToken(request);
        return ok(views.html.GameStart.render(csrfToken));
    }

    public Result postGameStart(Http.Request request)
    {
        Html csrfToken = getCSRFToken(request);
        return ok(views.html.Cottage.render(csrfToken));
    }

    public Result postCalmYeti(Http.Request request)
    {
        return ok(views.html.Lose.render());
    }

    public Result postRunFromCottage(Http.Request request)
    {
        Html csrfToken = getCSRFToken(request);
        return ok(views.html.RunFromCottage.render(csrfToken));
    }

    private Html getCSRFToken(Http.Request request)
    {
        return CSRF.formField(request.asScala());
    }

}
