package models

import play.api.libs.json._

case class SaveCustomerResponse(rowsAffected: Int)

object SaveCustomerResponse {
  implicit val saveResponseFormat = Json.format[SaveCustomerResponse]
  }

