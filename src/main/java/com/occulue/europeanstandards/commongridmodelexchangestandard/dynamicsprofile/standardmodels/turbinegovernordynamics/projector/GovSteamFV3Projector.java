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
 * Projector for GovSteamFV3 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteamFV3 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteamFV3Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamFV3")
@Component("govSteamFV3-projector")
public class GovSteamFV3Projector extends GovSteamFV3EntityProjector {

  // core constructor
  public GovSteamFV3Projector(
      GovSteamFV3Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamFV3Event
   */
  @EventHandler(payloadType = CreateGovSteamFV3Event.class)
  public void handle(CreateGovSteamFV3Event event) {
    LOGGER.info("handling CreateGovSteamFV3Event - " + event);
    GovSteamFV3 entity = new GovSteamFV3();
    entity.setGovSteamFV3Id(event.getGovSteamFV3Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UpdateGovSteamFV3Event
   */
  @EventHandler(payloadType = UpdateGovSteamFV3Event.class)
  public void handle(UpdateGovSteamFV3Event event) {
    LOGGER.info("handling UpdateGovSteamFV3Event - " + event);

    GovSteamFV3 entity = new GovSteamFV3();
    entity.setGovSteamFV3Id(event.getGovSteamFV3Id());
    entity.setK(event.getK());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setMwbase(event.getMwbase());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setPrmax(event.getPrmax());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setUc(event.getUc());
    entity.setUo(event.getUo());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event DeleteGovSteamFV3Event
   */
  @EventHandler(payloadType = DeleteGovSteamFV3Event.class)
  public void handle(DeleteGovSteamFV3Event event) {
    LOGGER.info("handling DeleteGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamFV3 entity = delete(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignKToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignKToGovSteamFV3Event.class)
  public void handle(AssignKToGovSteamFV3Event event) {
    LOGGER.info("handling AssignKToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignK(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignKFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignKFromGovSteamFV3Event.class)
  public void handle(UnAssignKFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignKFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignK(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignK1ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignK1ToGovSteamFV3Event.class)
  public void handle(AssignK1ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignK1ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignK1(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignK1FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignK1FromGovSteamFV3Event.class)
  public void handle(UnAssignK1FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignK1FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignK1(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignK2ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignK2ToGovSteamFV3Event.class)
  public void handle(AssignK2ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignK2ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignK2(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignK2FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignK2FromGovSteamFV3Event.class)
  public void handle(UnAssignK2FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignK2FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignK2(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignK3ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignK3ToGovSteamFV3Event.class)
  public void handle(AssignK3ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignK3ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignK3(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignK3FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignK3FromGovSteamFV3Event.class)
  public void handle(UnAssignK3FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignK3FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignK3(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteamFV3Event.class)
  public void handle(AssignMwbaseToGovSteamFV3Event event) {
    LOGGER.info("handling AssignMwbaseToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignMwbase(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteamFV3Event.class)
  public void handle(UnAssignMwbaseFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignMwbase(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignPmaxToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignPmaxToGovSteamFV3Event.class)
  public void handle(AssignPmaxToGovSteamFV3Event event) {
    LOGGER.info("handling AssignPmaxToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignPmax(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovSteamFV3Event.class)
  public void handle(UnAssignPmaxFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignPmax(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignPminToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignPminToGovSteamFV3Event.class)
  public void handle(AssignPminToGovSteamFV3Event event) {
    LOGGER.info("handling AssignPminToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignPmin(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignPminFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovSteamFV3Event.class)
  public void handle(UnAssignPminFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignPminFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignPmin(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignPrmaxToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignPrmaxToGovSteamFV3Event.class)
  public void handle(AssignPrmaxToGovSteamFV3Event event) {
    LOGGER.info("handling AssignPrmaxToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignPrmax(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignPrmaxFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignPrmaxFromGovSteamFV3Event.class)
  public void handle(UnAssignPrmaxFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignPrmaxFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignPrmax(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignT1ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignT1ToGovSteamFV3Event.class)
  public void handle(AssignT1ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignT1ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignT1(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteamFV3Event.class)
  public void handle(UnAssignT1FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignT1FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignT1(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignT2ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignT2ToGovSteamFV3Event.class)
  public void handle(AssignT2ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignT2ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignT2(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignT2FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovSteamFV3Event.class)
  public void handle(UnAssignT2FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignT2FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignT2(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignT3ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignT3ToGovSteamFV3Event.class)
  public void handle(AssignT3ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignT3ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignT3(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignT3FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovSteamFV3Event.class)
  public void handle(UnAssignT3FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignT3FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignT3(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignT4ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignT4ToGovSteamFV3Event.class)
  public void handle(AssignT4ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignT4ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignT4(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignT4FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignT4FromGovSteamFV3Event.class)
  public void handle(UnAssignT4FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignT4FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignT4(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignT5ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignT5ToGovSteamFV3Event.class)
  public void handle(AssignT5ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignT5ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignT5(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignT5FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignT5FromGovSteamFV3Event.class)
  public void handle(UnAssignT5FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignT5FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignT5(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignT6ToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignT6ToGovSteamFV3Event.class)
  public void handle(AssignT6ToGovSteamFV3Event event) {
    LOGGER.info("handling AssignT6ToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignT6(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignT6FromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignT6FromGovSteamFV3Event.class)
  public void handle(UnAssignT6FromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignT6FromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignT6(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignTaToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignTaToGovSteamFV3Event.class)
  public void handle(AssignTaToGovSteamFV3Event event) {
    LOGGER.info("handling AssignTaToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignTa(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignTaFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovSteamFV3Event.class)
  public void handle(UnAssignTaFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignTaFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignTa(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignTbToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignTbToGovSteamFV3Event.class)
  public void handle(AssignTbToGovSteamFV3Event event) {
    LOGGER.info("handling AssignTbToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignTb(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignTbFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignTbFromGovSteamFV3Event.class)
  public void handle(UnAssignTbFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignTbFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignTb(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignTcToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignTcToGovSteamFV3Event.class)
  public void handle(AssignTcToGovSteamFV3Event event) {
    LOGGER.info("handling AssignTcToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignTc(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignTcFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignTcFromGovSteamFV3Event.class)
  public void handle(UnAssignTcFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignTcFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignTc(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignUcToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignUcToGovSteamFV3Event.class)
  public void handle(AssignUcToGovSteamFV3Event event) {
    LOGGER.info("handling AssignUcToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignUc(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignUcFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignUcFromGovSteamFV3Event.class)
  public void handle(UnAssignUcFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignUcFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignUc(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event AssignUoToGovSteamFV3Event
   */
  @EventHandler(payloadType = AssignUoToGovSteamFV3Event.class)
  public void handle(AssignUoToGovSteamFV3Event event) {
    LOGGER.info("handling AssignUoToGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamFV3 entity = assignUo(event.getGovSteamFV3Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /*
   * @param	event UnAssignUoFromGovSteamFV3Event
   */
  @EventHandler(payloadType = UnAssignUoFromGovSteamFV3Event.class)
  public void handle(UnAssignUoFromGovSteamFV3Event event) {
    LOGGER.info("handling UnAssignUoFromGovSteamFV3Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamFV3 entity = unAssignUo(event.getGovSteamFV3Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamFV3(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamFV3(entity);
  }

  /**
   * Method to retrieve the GovSteamFV3 via an GovSteamFV3PrimaryKey.
   *
   * @param id Long
   * @return GovSteamFV3
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamFV3 handle(FindGovSteamFV3Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamFV3Id());
  }

  /**
   * Method to retrieve a collection of all GovSteamFV3s
   *
   * @param query FindAllGovSteamFV3Query
   * @return List<GovSteamFV3>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamFV3> handle(FindAllGovSteamFV3Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamFV3, but only if the id matches
   *
   * @param entity GovSteamFV3
   */
  protected void emitFindGovSteamFV3(GovSteamFV3 entity) {
    LOGGER.info("handling emitFindGovSteamFV3");

    queryUpdateEmitter.emit(
        FindGovSteamFV3Query.class,
        query -> query.getFilter().getGovSteamFV3Id().equals(entity.getGovSteamFV3Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamFV3
   *
   * @param entity GovSteamFV3
   */
  protected void emitFindAllGovSteamFV3(GovSteamFV3 entity) {
    LOGGER.info("handling emitFindAllGovSteamFV3");

    queryUpdateEmitter.emit(FindAllGovSteamFV3Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamFV3Projector.class.getName());
}
