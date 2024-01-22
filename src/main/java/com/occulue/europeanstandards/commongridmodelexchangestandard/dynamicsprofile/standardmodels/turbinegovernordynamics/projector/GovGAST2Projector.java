/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for GovGAST2 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovGAST2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovGAST2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govGAST2")
@Component("govGAST2-projector")
public class GovGAST2Projector extends GovGAST2EntityProjector {

  // core constructor
  public GovGAST2Projector(GovGAST2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovGAST2Event
   */
  @EventHandler(payloadType = CreateGovGAST2Event.class)
  public void handle(CreateGovGAST2Event event) {
    LOGGER.info("handling CreateGovGAST2Event - " + event);
    GovGAST2 entity = new GovGAST2();
    entity.setGovGAST2Id(event.getGovGAST2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UpdateGovGAST2Event
   */
  @EventHandler(payloadType = UpdateGovGAST2Event.class)
  public void handle(UpdateGovGAST2Event event) {
    LOGGER.info("handling UpdateGovGAST2Event - " + event);

    GovGAST2 entity = new GovGAST2();
    entity.setGovGAST2Id(event.getGovGAST2Id());
    entity.setA(event.getA());
    entity.setAf1(event.getAf1());
    entity.setAf2(event.getAf2());
    entity.setB(event.getB());
    entity.setBf1(event.getBf1());
    entity.setBf2(event.getBf2());
    entity.setC(event.getC());
    entity.setCf2(event.getCf2());
    entity.setEcr(event.getEcr());
    entity.setEtd(event.getEtd());
    entity.setK3(event.getK3());
    entity.setK4(event.getK4());
    entity.setK5(event.getK5());
    entity.setK6(event.getK6());
    entity.setKf(event.getKf());
    entity.setMwbase(event.getMwbase());
    entity.setT(event.getT());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setTc(event.getTc());
    entity.setTcd(event.getTcd());
    entity.setTf(event.getTf());
    entity.setTmax(event.getTmax());
    entity.setTmin(event.getTmin());
    entity.setTr(event.getTr());
    entity.setTrate(event.getTrate());
    entity.setTt(event.getTt());
    entity.setW(event.getW());
    entity.setX(event.getX());
    entity.setY(event.getY());
    entity.setZ(event.getZ());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event DeleteGovGAST2Event
   */
  @EventHandler(payloadType = DeleteGovGAST2Event.class)
  public void handle(DeleteGovGAST2Event event) {
    LOGGER.info("handling DeleteGovGAST2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovGAST2 entity = delete(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignAToGovGAST2Event
   */
  @EventHandler(payloadType = AssignAToGovGAST2Event.class)
  public void handle(AssignAToGovGAST2Event event) {
    LOGGER.info("handling AssignAToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignA(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignAFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignAFromGovGAST2Event.class)
  public void handle(UnAssignAFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignAFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignA(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignAf1ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignAf1ToGovGAST2Event.class)
  public void handle(AssignAf1ToGovGAST2Event event) {
    LOGGER.info("handling AssignAf1ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignAf1(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignAf1FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignAf1FromGovGAST2Event.class)
  public void handle(UnAssignAf1FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignAf1FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignAf1(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignAf2ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignAf2ToGovGAST2Event.class)
  public void handle(AssignAf2ToGovGAST2Event event) {
    LOGGER.info("handling AssignAf2ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignAf2(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignAf2FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignAf2FromGovGAST2Event.class)
  public void handle(UnAssignAf2FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignAf2FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignAf2(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignBToGovGAST2Event
   */
  @EventHandler(payloadType = AssignBToGovGAST2Event.class)
  public void handle(AssignBToGovGAST2Event event) {
    LOGGER.info("handling AssignBToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignB(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignBFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignBFromGovGAST2Event.class)
  public void handle(UnAssignBFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignBFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignB(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignBf1ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignBf1ToGovGAST2Event.class)
  public void handle(AssignBf1ToGovGAST2Event event) {
    LOGGER.info("handling AssignBf1ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignBf1(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignBf1FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignBf1FromGovGAST2Event.class)
  public void handle(UnAssignBf1FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignBf1FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignBf1(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignBf2ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignBf2ToGovGAST2Event.class)
  public void handle(AssignBf2ToGovGAST2Event event) {
    LOGGER.info("handling AssignBf2ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignBf2(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignBf2FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignBf2FromGovGAST2Event.class)
  public void handle(UnAssignBf2FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignBf2FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignBf2(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignCToGovGAST2Event
   */
  @EventHandler(payloadType = AssignCToGovGAST2Event.class)
  public void handle(AssignCToGovGAST2Event event) {
    LOGGER.info("handling AssignCToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignC(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignCFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignCFromGovGAST2Event.class)
  public void handle(UnAssignCFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignCFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignC(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignCf2ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignCf2ToGovGAST2Event.class)
  public void handle(AssignCf2ToGovGAST2Event event) {
    LOGGER.info("handling AssignCf2ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignCf2(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignCf2FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignCf2FromGovGAST2Event.class)
  public void handle(UnAssignCf2FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignCf2FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignCf2(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignEcrToGovGAST2Event
   */
  @EventHandler(payloadType = AssignEcrToGovGAST2Event.class)
  public void handle(AssignEcrToGovGAST2Event event) {
    LOGGER.info("handling AssignEcrToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignEcr(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignEcrFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignEcrFromGovGAST2Event.class)
  public void handle(UnAssignEcrFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignEcrFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignEcr(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignEtdToGovGAST2Event
   */
  @EventHandler(payloadType = AssignEtdToGovGAST2Event.class)
  public void handle(AssignEtdToGovGAST2Event event) {
    LOGGER.info("handling AssignEtdToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignEtd(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignEtdFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignEtdFromGovGAST2Event.class)
  public void handle(UnAssignEtdFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignEtdFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignEtd(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignK3ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignK3ToGovGAST2Event.class)
  public void handle(AssignK3ToGovGAST2Event event) {
    LOGGER.info("handling AssignK3ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignK3(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignK3FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignK3FromGovGAST2Event.class)
  public void handle(UnAssignK3FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignK3FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignK3(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignK4ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignK4ToGovGAST2Event.class)
  public void handle(AssignK4ToGovGAST2Event event) {
    LOGGER.info("handling AssignK4ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignK4(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignK4FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignK4FromGovGAST2Event.class)
  public void handle(UnAssignK4FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignK4FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignK4(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignK5ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignK5ToGovGAST2Event.class)
  public void handle(AssignK5ToGovGAST2Event event) {
    LOGGER.info("handling AssignK5ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignK5(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignK5FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignK5FromGovGAST2Event.class)
  public void handle(UnAssignK5FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignK5FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignK5(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignK6ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignK6ToGovGAST2Event.class)
  public void handle(AssignK6ToGovGAST2Event event) {
    LOGGER.info("handling AssignK6ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignK6(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignK6FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignK6FromGovGAST2Event.class)
  public void handle(UnAssignK6FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignK6FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignK6(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignKfToGovGAST2Event
   */
  @EventHandler(payloadType = AssignKfToGovGAST2Event.class)
  public void handle(AssignKfToGovGAST2Event event) {
    LOGGER.info("handling AssignKfToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignKf(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignKfFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignKfFromGovGAST2Event.class)
  public void handle(UnAssignKfFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignKfFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignKf(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignMwbaseToGovGAST2Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovGAST2Event.class)
  public void handle(AssignMwbaseToGovGAST2Event event) {
    LOGGER.info("handling AssignMwbaseToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignMwbase(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovGAST2Event.class)
  public void handle(UnAssignMwbaseFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignMwbase(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTToGovGAST2Event.class)
  public void handle(AssignTToGovGAST2Event event) {
    LOGGER.info("handling AssignTToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignT(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTFromGovGAST2Event.class)
  public void handle(UnAssignTFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignT(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignT3ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignT3ToGovGAST2Event.class)
  public void handle(AssignT3ToGovGAST2Event event) {
    LOGGER.info("handling AssignT3ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignT3(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignT3FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovGAST2Event.class)
  public void handle(UnAssignT3FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignT3FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignT3(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignT4ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignT4ToGovGAST2Event.class)
  public void handle(AssignT4ToGovGAST2Event event) {
    LOGGER.info("handling AssignT4ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignT4(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignT4FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignT4FromGovGAST2Event.class)
  public void handle(UnAssignT4FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignT4FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignT4(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignT5ToGovGAST2Event
   */
  @EventHandler(payloadType = AssignT5ToGovGAST2Event.class)
  public void handle(AssignT5ToGovGAST2Event event) {
    LOGGER.info("handling AssignT5ToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignT5(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignT5FromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignT5FromGovGAST2Event.class)
  public void handle(UnAssignT5FromGovGAST2Event event) {
    LOGGER.info("handling UnAssignT5FromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignT5(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTcToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTcToGovGAST2Event.class)
  public void handle(AssignTcToGovGAST2Event event) {
    LOGGER.info("handling AssignTcToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTc(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTcFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovGAST2Event.class)
  public void handle(UnAssignTcFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTcFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTc(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTcdToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTcdToGovGAST2Event.class)
  public void handle(AssignTcdToGovGAST2Event event) {
    LOGGER.info("handling AssignTcdToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTcd(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTcdFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTcdFromGovGAST2Event.class)
  public void handle(UnAssignTcdFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTcdFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTcd(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTfToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTfToGovGAST2Event.class)
  public void handle(AssignTfToGovGAST2Event event) {
    LOGGER.info("handling AssignTfToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTf(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTfFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTfFromGovGAST2Event.class)
  public void handle(UnAssignTfFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTfFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTf(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTmaxToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTmaxToGovGAST2Event.class)
  public void handle(AssignTmaxToGovGAST2Event event) {
    LOGGER.info("handling AssignTmaxToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTmax(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTmaxFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTmaxFromGovGAST2Event.class)
  public void handle(UnAssignTmaxFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTmaxFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTmax(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTminToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTminToGovGAST2Event.class)
  public void handle(AssignTminToGovGAST2Event event) {
    LOGGER.info("handling AssignTminToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTmin(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTminFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTminFromGovGAST2Event.class)
  public void handle(UnAssignTminFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTminFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTmin(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTrToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTrToGovGAST2Event.class)
  public void handle(AssignTrToGovGAST2Event event) {
    LOGGER.info("handling AssignTrToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTr(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTrFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTrFromGovGAST2Event.class)
  public void handle(UnAssignTrFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTrFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTr(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTrateToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTrateToGovGAST2Event.class)
  public void handle(AssignTrateToGovGAST2Event event) {
    LOGGER.info("handling AssignTrateToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTrate(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTrateFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTrateFromGovGAST2Event.class)
  public void handle(UnAssignTrateFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTrateFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTrate(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignTtToGovGAST2Event
   */
  @EventHandler(payloadType = AssignTtToGovGAST2Event.class)
  public void handle(AssignTtToGovGAST2Event event) {
    LOGGER.info("handling AssignTtToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignTt(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignTtFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignTtFromGovGAST2Event.class)
  public void handle(UnAssignTtFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignTtFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignTt(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignWToGovGAST2Event
   */
  @EventHandler(payloadType = AssignWToGovGAST2Event.class)
  public void handle(AssignWToGovGAST2Event event) {
    LOGGER.info("handling AssignWToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignW(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignWFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignWFromGovGAST2Event.class)
  public void handle(UnAssignWFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignWFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignW(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignXToGovGAST2Event
   */
  @EventHandler(payloadType = AssignXToGovGAST2Event.class)
  public void handle(AssignXToGovGAST2Event event) {
    LOGGER.info("handling AssignXToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignX(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignXFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignXFromGovGAST2Event.class)
  public void handle(UnAssignXFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignXFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignX(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignYToGovGAST2Event
   */
  @EventHandler(payloadType = AssignYToGovGAST2Event.class)
  public void handle(AssignYToGovGAST2Event event) {
    LOGGER.info("handling AssignYToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignY(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignYFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignYFromGovGAST2Event.class)
  public void handle(UnAssignYFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignYFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignY(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event AssignZToGovGAST2Event
   */
  @EventHandler(payloadType = AssignZToGovGAST2Event.class)
  public void handle(AssignZToGovGAST2Event event) {
    LOGGER.info("handling AssignZToGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovGAST2 entity = assignZ(event.getGovGAST2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /*
   * @param	event UnAssignZFromGovGAST2Event
   */
  @EventHandler(payloadType = UnAssignZFromGovGAST2Event.class)
  public void handle(UnAssignZFromGovGAST2Event event) {
    LOGGER.info("handling UnAssignZFromGovGAST2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovGAST2 entity = unAssignZ(event.getGovGAST2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovGAST2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovGAST2(entity);
  }

  /**
   * Method to retrieve the GovGAST2 via an GovGAST2PrimaryKey.
   *
   * @param id Long
   * @return GovGAST2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovGAST2 handle(FindGovGAST2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovGAST2Id());
  }

  /**
   * Method to retrieve a collection of all GovGAST2s
   *
   * @param query FindAllGovGAST2Query
   * @return List<GovGAST2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovGAST2> handle(FindAllGovGAST2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovGAST2, but only if the id matches
   *
   * @param entity GovGAST2
   */
  protected void emitFindGovGAST2(GovGAST2 entity) {
    LOGGER.info("handling emitFindGovGAST2");

    queryUpdateEmitter.emit(
        FindGovGAST2Query.class,
        query -> query.getFilter().getGovGAST2Id().equals(entity.getGovGAST2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovGAST2
   *
   * @param entity GovGAST2
   */
  protected void emitFindAllGovGAST2(GovGAST2 entity) {
    LOGGER.info("handling emitFindAllGovGAST2");

    queryUpdateEmitter.emit(FindAllGovGAST2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovGAST2Projector.class.getName());
}
