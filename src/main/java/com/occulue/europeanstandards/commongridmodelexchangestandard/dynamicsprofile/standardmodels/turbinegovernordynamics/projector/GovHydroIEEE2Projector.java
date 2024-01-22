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
 * Projector for GovHydroIEEE2 as outlined for the CQRS pattern. All event handling and query
 * handling related to GovHydroIEEE2 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovHydroIEEE2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroIEEE2")
@Component("govHydroIEEE2-projector")
public class GovHydroIEEE2Projector extends GovHydroIEEE2EntityProjector {

  // core constructor
  public GovHydroIEEE2Projector(
      GovHydroIEEE2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroIEEE2Event
   */
  @EventHandler(payloadType = CreateGovHydroIEEE2Event.class)
  public void handle(CreateGovHydroIEEE2Event event) {
    LOGGER.info("handling CreateGovHydroIEEE2Event - " + event);
    GovHydroIEEE2 entity = new GovHydroIEEE2();
    entity.setGovHydroIEEE2Id(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UpdateGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UpdateGovHydroIEEE2Event.class)
  public void handle(UpdateGovHydroIEEE2Event event) {
    LOGGER.info("handling UpdateGovHydroIEEE2Event - " + event);

    GovHydroIEEE2 entity = new GovHydroIEEE2();
    entity.setGovHydroIEEE2Id(event.getGovHydroIEEE2Id());
    entity.setAturb(event.getAturb());
    entity.setBturb(event.getBturb());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setGv4(event.getGv4());
    entity.setGv5(event.getGv5());
    entity.setGv6(event.getGv6());
    entity.setKturb(event.getKturb());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPgv4(event.getPgv4());
    entity.setPgv5(event.getPgv5());
    entity.setPgv6(event.getPgv6());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setRperm(event.getRperm());
    entity.setRtemp(event.getRtemp());
    entity.setTg(event.getTg());
    entity.setTp(event.getTp());
    entity.setTr(event.getTr());
    entity.setTw(event.getTw());
    entity.setUc(event.getUc());
    entity.setUo(event.getUo());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event DeleteGovHydroIEEE2Event
   */
  @EventHandler(payloadType = DeleteGovHydroIEEE2Event.class)
  public void handle(DeleteGovHydroIEEE2Event event) {
    LOGGER.info("handling DeleteGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroIEEE2 entity = delete(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignAturbToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignAturbToGovHydroIEEE2Event.class)
  public void handle(AssignAturbToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignAturbToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignAturb(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignAturbFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignAturbFromGovHydroIEEE2Event.class)
  public void handle(UnAssignAturbFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignAturbFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignAturb(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignBturbToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignBturbToGovHydroIEEE2Event.class)
  public void handle(AssignBturbToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignBturbToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignBturb(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignBturbFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignBturbFromGovHydroIEEE2Event.class)
  public void handle(UnAssignBturbFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignBturbFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignBturb(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignGv1ToGovHydroIEEE2Event.class)
  public void handle(AssignGv1ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignGv1ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignGv1(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydroIEEE2Event.class)
  public void handle(UnAssignGv1FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignGv1FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignGv1(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignGv2ToGovHydroIEEE2Event.class)
  public void handle(AssignGv2ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignGv2ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignGv2(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydroIEEE2Event.class)
  public void handle(UnAssignGv2FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignGv2FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignGv2(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignGv3ToGovHydroIEEE2Event.class)
  public void handle(AssignGv3ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignGv3ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignGv3(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydroIEEE2Event.class)
  public void handle(UnAssignGv3FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignGv3FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignGv3(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignGv4ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignGv4ToGovHydroIEEE2Event.class)
  public void handle(AssignGv4ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignGv4ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignGv4(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignGv4FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignGv4FromGovHydroIEEE2Event.class)
  public void handle(UnAssignGv4FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignGv4FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignGv4(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignGv5ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignGv5ToGovHydroIEEE2Event.class)
  public void handle(AssignGv5ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignGv5ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignGv5(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignGv5FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignGv5FromGovHydroIEEE2Event.class)
  public void handle(UnAssignGv5FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignGv5FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignGv5(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignGv6ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignGv6ToGovHydroIEEE2Event.class)
  public void handle(AssignGv6ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignGv6ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignGv6(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignGv6FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignGv6FromGovHydroIEEE2Event.class)
  public void handle(UnAssignGv6FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignGv6FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignGv6(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignKturbToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignKturbToGovHydroIEEE2Event.class)
  public void handle(AssignKturbToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignKturbToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignKturb(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignKturbFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignKturbFromGovHydroIEEE2Event.class)
  public void handle(UnAssignKturbFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignKturbFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignKturb(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroIEEE2Event.class)
  public void handle(AssignMwbaseToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignMwbase(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroIEEE2Event.class)
  public void handle(UnAssignMwbaseFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignMwbase(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydroIEEE2Event.class)
  public void handle(AssignPgv1ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPgv1ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPgv1(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydroIEEE2Event.class)
  public void handle(UnAssignPgv1FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPgv1(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydroIEEE2Event.class)
  public void handle(AssignPgv2ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPgv2ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPgv2(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydroIEEE2Event.class)
  public void handle(UnAssignPgv2FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPgv2(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydroIEEE2Event.class)
  public void handle(AssignPgv3ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPgv3ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPgv3(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydroIEEE2Event.class)
  public void handle(UnAssignPgv3FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPgv3(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPgv4ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPgv4ToGovHydroIEEE2Event.class)
  public void handle(AssignPgv4ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPgv4ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPgv4(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPgv4FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPgv4FromGovHydroIEEE2Event.class)
  public void handle(UnAssignPgv4FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPgv4FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPgv4(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPgv5ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPgv5ToGovHydroIEEE2Event.class)
  public void handle(AssignPgv5ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPgv5ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPgv5(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPgv5FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPgv5FromGovHydroIEEE2Event.class)
  public void handle(UnAssignPgv5FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPgv5FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPgv5(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPgv6ToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPgv6ToGovHydroIEEE2Event.class)
  public void handle(AssignPgv6ToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPgv6ToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPgv6(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPgv6FromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPgv6FromGovHydroIEEE2Event.class)
  public void handle(UnAssignPgv6FromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPgv6FromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPgv6(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPmaxToGovHydroIEEE2Event.class)
  public void handle(AssignPmaxToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPmaxToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPmax(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydroIEEE2Event.class)
  public void handle(UnAssignPmaxFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPmax(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignPminToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignPminToGovHydroIEEE2Event.class)
  public void handle(AssignPminToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignPminToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignPmin(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydroIEEE2Event.class)
  public void handle(UnAssignPminFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignPminFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignPmin(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignRpermToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignRpermToGovHydroIEEE2Event.class)
  public void handle(AssignRpermToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignRpermToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignRperm(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignRpermFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignRpermFromGovHydroIEEE2Event.class)
  public void handle(UnAssignRpermFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignRpermFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignRperm(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignRtempToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignRtempToGovHydroIEEE2Event.class)
  public void handle(AssignRtempToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignRtempToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignRtemp(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignRtempFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignRtempFromGovHydroIEEE2Event.class)
  public void handle(UnAssignRtempFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignRtempFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignRtemp(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignTgToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignTgToGovHydroIEEE2Event.class)
  public void handle(AssignTgToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignTgToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignTg(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignTgFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTgFromGovHydroIEEE2Event.class)
  public void handle(UnAssignTgFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignTgFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignTg(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignTpToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignTpToGovHydroIEEE2Event.class)
  public void handle(AssignTpToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignTpToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignTp(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignTpFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTpFromGovHydroIEEE2Event.class)
  public void handle(UnAssignTpFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignTpFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignTp(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignTrToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignTrToGovHydroIEEE2Event.class)
  public void handle(AssignTrToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignTrToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignTr(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignTrFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTrFromGovHydroIEEE2Event.class)
  public void handle(UnAssignTrFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignTrFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignTr(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignTwToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignTwToGovHydroIEEE2Event.class)
  public void handle(AssignTwToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignTwToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignTw(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydroIEEE2Event.class)
  public void handle(UnAssignTwFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignTwFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignTw(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignUcToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignUcToGovHydroIEEE2Event.class)
  public void handle(AssignUcToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignUcToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignUc(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignUcFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignUcFromGovHydroIEEE2Event.class)
  public void handle(UnAssignUcFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignUcFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignUc(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event AssignUoToGovHydroIEEE2Event
   */
  @EventHandler(payloadType = AssignUoToGovHydroIEEE2Event.class)
  public void handle(AssignUoToGovHydroIEEE2Event event) {
    LOGGER.info("handling AssignUoToGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE2 entity = assignUo(event.getGovHydroIEEE2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /*
   * @param	event UnAssignUoFromGovHydroIEEE2Event
   */
  @EventHandler(payloadType = UnAssignUoFromGovHydroIEEE2Event.class)
  public void handle(UnAssignUoFromGovHydroIEEE2Event event) {
    LOGGER.info("handling UnAssignUoFromGovHydroIEEE2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE2 entity = unAssignUo(event.getGovHydroIEEE2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE2(entity);
  }

  /**
   * Method to retrieve the GovHydroIEEE2 via an GovHydroIEEE2PrimaryKey.
   *
   * @param id Long
   * @return GovHydroIEEE2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroIEEE2 handle(FindGovHydroIEEE2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroIEEE2Id());
  }

  /**
   * Method to retrieve a collection of all GovHydroIEEE2s
   *
   * @param query FindAllGovHydroIEEE2Query
   * @return List<GovHydroIEEE2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroIEEE2> handle(FindAllGovHydroIEEE2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroIEEE2, but only if the id matches
   *
   * @param entity GovHydroIEEE2
   */
  protected void emitFindGovHydroIEEE2(GovHydroIEEE2 entity) {
    LOGGER.info("handling emitFindGovHydroIEEE2");

    queryUpdateEmitter.emit(
        FindGovHydroIEEE2Query.class,
        query -> query.getFilter().getGovHydroIEEE2Id().equals(entity.getGovHydroIEEE2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroIEEE2
   *
   * @param entity GovHydroIEEE2
   */
  protected void emitFindAllGovHydroIEEE2(GovHydroIEEE2 entity) {
    LOGGER.info("handling emitFindAllGovHydroIEEE2");

    queryUpdateEmitter.emit(FindAllGovHydroIEEE2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE2Projector.class.getName());
}
