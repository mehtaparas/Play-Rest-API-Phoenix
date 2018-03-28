package controllers

import javax.inject.Inject

import models._
import play.api.data.Forms._
import play.api.data._
import play.api.i18n._
import play.api.mvc._
import views._
import play.api.libs.json._

import scala.concurrent.{ExecutionContext, Future}

class HomeController @Inject()(customerService: CustomerRepository,
                               cc: MessagesControllerComponents)(implicit ec: ExecutionContext)
  extends MessagesAbstractController(cc) {

  private val logger = play.api.Logger(this.getClass)


  // -- Actions

  /**
    * Handle default path requests; show that service is running
    */
   
  def index = Action { implicit request =>
    Ok("REST API is running! Query for customers at endpoint:/customers/id")
    }


  /**
    * Display the customer.
    *
    * @param accountnbr Account Number of the customer to search for
    */
  
  def search(siteid: Int, accountnbr: Int) = Action.async { implicit request =>
    customerService.findById(siteid, accountnbr).map {
      customer => Ok(Json.toJson(customer))
    }
  }

  /**
    * Save a customer to UET.CI_ACCNT_NODE table in Phoenix based on JSON request body; example request body:
    * 
    * {"site_id": 1, "account_nbr": 123, "node": "TESTNODE123", "host": "TESTHOST123", "headend": "TESTHEADEND123"}
    *
    */

  def save = Action.async(parse.json) { request: Request[JsValue]  =>
    customerService.saveCustomer((request.body \ "site_id").as[Int],(request.body \ "account_nbr").as[Int],(request.body \ "node").as[String]
      ,(request.body \ "host").as[String],(request.body \ "headend").as[String]).map {
      responseString => Ok(Json.toJson(responseString))
    }
  }

}
            
