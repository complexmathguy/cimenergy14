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
 * Projector for GovHydroWPID as outlined for the CQRS pattern. All event handling and query
 * handling related to GovHydroWPID are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovHydroWPIDAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroWPID")
@Component("govHydroWPID-projector")
public class GovHydroWPIDProjector extends GovHydroWPIDEntityProjector {

  // core constructor
  public GovHydroWPIDProjector(
      GovHydroWPIDRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroWPIDEvent
   */
  @EventHandler(payloadType = CreateGovHydroWPIDEvent.class)
  public void handle(CreateGovHydroWPIDEvent event) {
    LOGGER.info("handling CreateGovHydroWPIDEvent - " + event);
    GovHydroWPID entity = new GovHydroWPID();
    entity.setGovHydroWPIDId(event.getGovHydroWPIDId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UpdateGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UpdateGovHydroWPIDEvent.class)
  public void handle(UpdateGovHydroWPIDEvent event) {
    LOGGER.info("handling UpdateGovHydroWPIDEvent - " + event);

    GovHydroWPID entity = new GovHydroWPID();
    entity.setGovHydroWPIDId(event.getGovHydroWPIDId());
    entity.setD(event.getD());
    entity.setGatmax(event.getGatmax());
    entity.setGatmin(event.getGatmin());
    entity.setGv1(event.getGv1());
    entity.setGv2(event.getGv2());
    entity.setGv3(event.getGv3());
    entity.setKd(event.getKd());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMwbase(event.getMwbase());
    entity.setPgv1(event.getPgv1());
    entity.setPgv2(event.getPgv2());
    entity.setPgv3(event.getPgv3());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setReg(event.getReg());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTreg(event.getTreg());
    entity.setTw(event.getTw());
    entity.setVelmax(event.getVelmax());
    entity.setVelmin(event.getVelmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event DeleteGovHydroWPIDEvent
   */
  @EventHandler(payloadType = DeleteGovHydroWPIDEvent.class)
  public void handle(DeleteGovHydroWPIDEvent event) {
    LOGGER.info("handling DeleteGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroWPID entity = delete(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignDToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignDToGovHydroWPIDEvent.class)
  public void handle(AssignDToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignDToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignD(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignDFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignDFromGovHydroWPIDEvent.class)
  public void handle(UnAssignDFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignDFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignD(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignGatmaxToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignGatmaxToGovHydroWPIDEvent.class)
  public void handle(AssignGatmaxToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignGatmaxToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignGatmax(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignGatmaxFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignGatmaxFromGovHydroWPIDEvent.class)
  public void handle(UnAssignGatmaxFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignGatmaxFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignGatmax(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignGatminToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignGatminToGovHydroWPIDEvent.class)
  public void handle(AssignGatminToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignGatminToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignGatmin(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignGatminFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignGatminFromGovHydroWPIDEvent.class)
  public void handle(UnAssignGatminFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignGatminFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignGatmin(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignGv1ToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignGv1ToGovHydroWPIDEvent.class)
  public void handle(AssignGv1ToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignGv1ToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignGv1(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignGv1FromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv1FromGovHydroWPIDEvent.class)
  public void handle(UnAssignGv1FromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignGv1FromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignGv1(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignGv2ToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignGv2ToGovHydroWPIDEvent.class)
  public void handle(AssignGv2ToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignGv2ToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignGv2(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignGv2FromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv2FromGovHydroWPIDEvent.class)
  public void handle(UnAssignGv2FromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignGv2FromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignGv2(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignGv3ToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignGv3ToGovHydroWPIDEvent.class)
  public void handle(AssignGv3ToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignGv3ToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignGv3(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignGv3FromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignGv3FromGovHydroWPIDEvent.class)
  public void handle(UnAssignGv3FromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignGv3FromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignGv3(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignKdToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignKdToGovHydroWPIDEvent.class)
  public void handle(AssignKdToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignKdToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignKd(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignKdFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignKdFromGovHydroWPIDEvent.class)
  public void handle(UnAssignKdFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignKdFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignKd(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignKiToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignKiToGovHydroWPIDEvent.class)
  public void handle(AssignKiToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignKiToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignKi(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydroWPIDEvent.class)
  public void handle(UnAssignKiFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignKiFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignKi(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignKpToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignKpToGovHydroWPIDEvent.class)
  public void handle(AssignKpToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignKpToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignKp(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignKpFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignKpFromGovHydroWPIDEvent.class)
  public void handle(UnAssignKpFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignKpFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignKp(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroWPIDEvent.class)
  public void handle(AssignMwbaseToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignMwbaseToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignMwbase(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroWPIDEvent.class)
  public void handle(UnAssignMwbaseFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignMwbase(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignPgv1ToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignPgv1ToGovHydroWPIDEvent.class)
  public void handle(AssignPgv1ToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignPgv1ToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignPgv1(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignPgv1FromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv1FromGovHydroWPIDEvent.class)
  public void handle(UnAssignPgv1FromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignPgv1FromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignPgv1(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignPgv2ToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignPgv2ToGovHydroWPIDEvent.class)
  public void handle(AssignPgv2ToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignPgv2ToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignPgv2(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignPgv2FromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv2FromGovHydroWPIDEvent.class)
  public void handle(UnAssignPgv2FromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignPgv2FromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignPgv2(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignPgv3ToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignPgv3ToGovHydroWPIDEvent.class)
  public void handle(AssignPgv3ToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignPgv3ToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignPgv3(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignPgv3FromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignPgv3FromGovHydroWPIDEvent.class)
  public void handle(UnAssignPgv3FromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignPgv3FromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignPgv3(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignPmaxToGovHydroWPIDEvent.class)
  public void handle(AssignPmaxToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignPmaxToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignPmax(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydroWPIDEvent.class)
  public void handle(UnAssignPmaxFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignPmax(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignPminToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignPminToGovHydroWPIDEvent.class)
  public void handle(AssignPminToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignPminToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignPmin(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydroWPIDEvent.class)
  public void handle(UnAssignPminFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignPminFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignPmin(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignRegToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignRegToGovHydroWPIDEvent.class)
  public void handle(AssignRegToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignRegToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignReg(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignRegFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignRegFromGovHydroWPIDEvent.class)
  public void handle(UnAssignRegFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignRegFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignReg(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignTaToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignTaToGovHydroWPIDEvent.class)
  public void handle(AssignTaToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignTaToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignTa(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignTaFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignTaFromGovHydroWPIDEvent.class)
  public void handle(UnAssignTaFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignTaFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignTa(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignTbToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignTbToGovHydroWPIDEvent.class)
  public void handle(AssignTbToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignTbToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignTb(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignTbFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignTbFromGovHydroWPIDEvent.class)
  public void handle(UnAssignTbFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignTbFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignTb(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignTregToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignTregToGovHydroWPIDEvent.class)
  public void handle(AssignTregToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignTregToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignTreg(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignTregFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignTregFromGovHydroWPIDEvent.class)
  public void handle(UnAssignTregFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignTregFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignTreg(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignTwToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignTwToGovHydroWPIDEvent.class)
  public void handle(AssignTwToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignTwToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignTw(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydroWPIDEvent.class)
  public void handle(UnAssignTwFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignTwFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignTw(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignVelmaxToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignVelmaxToGovHydroWPIDEvent.class)
  public void handle(AssignVelmaxToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignVelmaxToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignVelmax(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignVelmaxFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignVelmaxFromGovHydroWPIDEvent.class)
  public void handle(UnAssignVelmaxFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignVelmaxFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignVelmax(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event AssignVelminToGovHydroWPIDEvent
   */
  @EventHandler(payloadType = AssignVelminToGovHydroWPIDEvent.class)
  public void handle(AssignVelminToGovHydroWPIDEvent event) {
    LOGGER.info("handling AssignVelminToGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroWPID entity = assignVelmin(event.getGovHydroWPIDId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /*
   * @param	event UnAssignVelminFromGovHydroWPIDEvent
   */
  @EventHandler(payloadType = UnAssignVelminFromGovHydroWPIDEvent.class)
  public void handle(UnAssignVelminFromGovHydroWPIDEvent event) {
    LOGGER.info("handling UnAssignVelminFromGovHydroWPIDEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroWPID entity = unAssignVelmin(event.getGovHydroWPIDId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroWPID(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroWPID(entity);
  }

  /**
   * Method to retrieve the GovHydroWPID via an GovHydroWPIDPrimaryKey.
   *
   * @param id Long
   * @return GovHydroWPID
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroWPID handle(FindGovHydroWPIDQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroWPIDId());
  }

  /**
   * Method to retrieve a collection of all GovHydroWPIDs
   *
   * @param query FindAllGovHydroWPIDQuery
   * @return List<GovHydroWPID>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroWPID> handle(FindAllGovHydroWPIDQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroWPID, but only if the id matches
   *
   * @param entity GovHydroWPID
   */
  protected void emitFindGovHydroWPID(GovHydroWPID entity) {
    LOGGER.info("handling emitFindGovHydroWPID");

    queryUpdateEmitter.emit(
        FindGovHydroWPIDQuery.class,
        query -> query.getFilter().getGovHydroWPIDId().equals(entity.getGovHydroWPIDId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroWPID
   *
   * @param entity GovHydroWPID
   */
  protected void emitFindAllGovHydroWPID(GovHydroWPID entity) {
    LOGGER.info("handling emitFindAllGovHydroWPID");

    queryUpdateEmitter.emit(FindAllGovHydroWPIDQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroWPIDProjector.class.getName());
}
