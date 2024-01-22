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
 * Projector for GovSteamIEEE1 as outlined for the CQRS pattern. All event handling and query
 * handling related to GovSteamIEEE1 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovSteamIEEE1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteamIEEE1")
@Component("govSteamIEEE1-projector")
public class GovSteamIEEE1Projector extends GovSteamIEEE1EntityProjector {

  // core constructor
  public GovSteamIEEE1Projector(
      GovSteamIEEE1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteamIEEE1Event
   */
  @EventHandler(payloadType = CreateGovSteamIEEE1Event.class)
  public void handle(CreateGovSteamIEEE1Event event) {
    LOGGER.info("handling CreateGovSteamIEEE1Event - " + event);
    GovSteamIEEE1 entity = new GovSteamIEEE1();
    entity.setGovSteamIEEE1Id(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UpdateGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UpdateGovSteamIEEE1Event.class)
  public void handle(UpdateGovSteamIEEE1Event event) {
    LOGGER.info("handling UpdateGovSteamIEEE1Event - " + event);

    GovSteamIEEE1 entity = new GovSteamIEEE1();
    entity.setGovSteamIEEE1Id(event.getGovSteamIEEE1Id());
    entity.setK(event.getK());
    entity.setK1(event.getK1());
    entity.setK2(event.getK2());
    entity.setK3(event.getK3());
    entity.setK4(event.getK4());
    entity.setK5(event.getK5());
    entity.setK6(event.getK6());
    entity.setK7(event.getK7());
    entity.setK8(event.getK8());
    entity.setMwbase(event.getMwbase());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());
    entity.setT5(event.getT5());
    entity.setT6(event.getT6());
    entity.setT7(event.getT7());
    entity.setUc(event.getUc());
    entity.setUo(event.getUo());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event DeleteGovSteamIEEE1Event
   */
  @EventHandler(payloadType = DeleteGovSteamIEEE1Event.class)
  public void handle(DeleteGovSteamIEEE1Event event) {
    LOGGER.info("handling DeleteGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteamIEEE1 entity = delete(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignKToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignKToGovSteamIEEE1Event.class)
  public void handle(AssignKToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignKToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignKFromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignKFromGovSteamIEEE1Event.class)
  public void handle(UnAssignKFromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignKFromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK1ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK1ToGovSteamIEEE1Event.class)
  public void handle(AssignK1ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK1ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK1(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK1FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK1FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK1FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK1FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK1(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK2ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK2ToGovSteamIEEE1Event.class)
  public void handle(AssignK2ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK2ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK2(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK2FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK2FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK2FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK2FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK2(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK3ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK3ToGovSteamIEEE1Event.class)
  public void handle(AssignK3ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK3ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK3(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK3FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK3FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK3FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK3FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK3(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK4ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK4ToGovSteamIEEE1Event.class)
  public void handle(AssignK4ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK4ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK4(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK4FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK4FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK4FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK4FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK4(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK5ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK5ToGovSteamIEEE1Event.class)
  public void handle(AssignK5ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK5ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK5(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK5FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK5FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK5FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK5FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK5(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK6ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK6ToGovSteamIEEE1Event.class)
  public void handle(AssignK6ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK6ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK6(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK6FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK6FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK6FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK6FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK6(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK7ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK7ToGovSteamIEEE1Event.class)
  public void handle(AssignK7ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK7ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK7(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK7FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK7FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK7FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK7FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK7(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignK8ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignK8ToGovSteamIEEE1Event.class)
  public void handle(AssignK8ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignK8ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignK8(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignK8FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignK8FromGovSteamIEEE1Event.class)
  public void handle(UnAssignK8FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignK8FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignK8(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignMwbaseToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovSteamIEEE1Event.class)
  public void handle(AssignMwbaseToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignMwbaseToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignMwbase(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovSteamIEEE1Event.class)
  public void handle(UnAssignMwbaseFromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignMwbase(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignPmaxToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignPmaxToGovSteamIEEE1Event.class)
  public void handle(AssignPmaxToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignPmaxToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignPmax(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovSteamIEEE1Event.class)
  public void handle(UnAssignPmaxFromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignPmax(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignPminToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignPminToGovSteamIEEE1Event.class)
  public void handle(AssignPminToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignPminToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignPmin(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignPminFromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovSteamIEEE1Event.class)
  public void handle(UnAssignPminFromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignPminFromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignPmin(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT1ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT1ToGovSteamIEEE1Event.class)
  public void handle(AssignT1ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT1ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT1(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT1FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT1FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT1(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT2ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT2ToGovSteamIEEE1Event.class)
  public void handle(AssignT2ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT2ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT2(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT2FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT2FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT2FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT2(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT3ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT3ToGovSteamIEEE1Event.class)
  public void handle(AssignT3ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT3ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT3(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT3FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT3FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT3FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT3(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT4ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT4ToGovSteamIEEE1Event.class)
  public void handle(AssignT4ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT4ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT4(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT4FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT4FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT4FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT4FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT4(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT5ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT5ToGovSteamIEEE1Event.class)
  public void handle(AssignT5ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT5ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT5(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT5FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT5FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT5FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT5FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT5(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT6ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT6ToGovSteamIEEE1Event.class)
  public void handle(AssignT6ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT6ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT6(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT6FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT6FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT6FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT6FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT6(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignT7ToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignT7ToGovSteamIEEE1Event.class)
  public void handle(AssignT7ToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignT7ToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignT7(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignT7FromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignT7FromGovSteamIEEE1Event.class)
  public void handle(UnAssignT7FromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignT7FromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignT7(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignUcToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignUcToGovSteamIEEE1Event.class)
  public void handle(AssignUcToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignUcToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignUc(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignUcFromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignUcFromGovSteamIEEE1Event.class)
  public void handle(UnAssignUcFromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignUcFromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignUc(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event AssignUoToGovSteamIEEE1Event
   */
  @EventHandler(payloadType = AssignUoToGovSteamIEEE1Event.class)
  public void handle(AssignUoToGovSteamIEEE1Event event) {
    LOGGER.info("handling AssignUoToGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteamIEEE1 entity = assignUo(event.getGovSteamIEEE1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /*
   * @param	event UnAssignUoFromGovSteamIEEE1Event
   */
  @EventHandler(payloadType = UnAssignUoFromGovSteamIEEE1Event.class)
  public void handle(UnAssignUoFromGovSteamIEEE1Event event) {
    LOGGER.info("handling UnAssignUoFromGovSteamIEEE1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteamIEEE1 entity = unAssignUo(event.getGovSteamIEEE1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteamIEEE1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteamIEEE1(entity);
  }

  /**
   * Method to retrieve the GovSteamIEEE1 via an GovSteamIEEE1PrimaryKey.
   *
   * @param id Long
   * @return GovSteamIEEE1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteamIEEE1 handle(FindGovSteamIEEE1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteamIEEE1Id());
  }

  /**
   * Method to retrieve a collection of all GovSteamIEEE1s
   *
   * @param query FindAllGovSteamIEEE1Query
   * @return List<GovSteamIEEE1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteamIEEE1> handle(FindAllGovSteamIEEE1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteamIEEE1, but only if the id matches
   *
   * @param entity GovSteamIEEE1
   */
  protected void emitFindGovSteamIEEE1(GovSteamIEEE1 entity) {
    LOGGER.info("handling emitFindGovSteamIEEE1");

    queryUpdateEmitter.emit(
        FindGovSteamIEEE1Query.class,
        query -> query.getFilter().getGovSteamIEEE1Id().equals(entity.getGovSteamIEEE1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteamIEEE1
   *
   * @param entity GovSteamIEEE1
   */
  protected void emitFindAllGovSteamIEEE1(GovSteamIEEE1 entity) {
    LOGGER.info("handling emitFindAllGovSteamIEEE1");

    queryUpdateEmitter.emit(FindAllGovSteamIEEE1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteamIEEE1Projector.class.getName());
}
