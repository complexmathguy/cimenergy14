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
 * Projector for GovHydroPID2 as outlined for the CQRS pattern. All event handling and query
 * handling related to GovHydroPID2 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovHydroPID2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroPID2")
@Component("govHydroPID2-projector")
public class GovHydroPID2Projector extends GovHydroPID2EntityProjector {

  // core constructor
  public GovHydroPID2Projector(
      GovHydroPID2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroPID2Event
   */
  @EventHandler(payloadType = CreateGovHydroPID2Event.class)
  public void handle(CreateGovHydroPID2Event event) {
    LOGGER.info("handling CreateGovHydroPID2Event - " + event);
    GovHydroPID2 entity = new GovHydroPID2();
    entity.setGovHydroPID2Id(event.getGovHydroPID2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UpdateGovHydroPID2Event
   */
  @EventHandler(payloadType = UpdateGovHydroPID2Event.class)
  public void handle(UpdateGovHydroPID2Event event) {
    LOGGER.info("handling UpdateGovHydroPID2Event - " + event);

    GovHydroPID2 entity = new GovHydroPID2();
    entity.setGovHydroPID2Id(event.getGovHydroPID2Id());
    entity.setAtw(event.getAtw());
    entity.setD(event.getD());
    entity.setFeedbackSignal(event.getFeedbackSignal());
    entity.setG0(event.getG0());
    entity.setG1(event.getG1());
    entity.setG2(event.getG2());
    entity.setGmax(event.getGmax());
    entity.setGmin(event.getGmin());
    entity.setKd(event.getKd());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMwbase(event.getMwbase());
    entity.setP1(event.getP1());
    entity.setP2(event.getP2());
    entity.setP3(event.getP3());
    entity.setRperm(event.getRperm());
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
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event DeleteGovHydroPID2Event
   */
  @EventHandler(payloadType = DeleteGovHydroPID2Event.class)
  public void handle(DeleteGovHydroPID2Event event) {
    LOGGER.info("handling DeleteGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroPID2 entity = delete(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignAtwToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignAtwToGovHydroPID2Event.class)
  public void handle(AssignAtwToGovHydroPID2Event event) {
    LOGGER.info("handling AssignAtwToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignAtw(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignAtwFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignAtwFromGovHydroPID2Event.class)
  public void handle(UnAssignAtwFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignAtwFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignAtw(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignDToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignDToGovHydroPID2Event.class)
  public void handle(AssignDToGovHydroPID2Event event) {
    LOGGER.info("handling AssignDToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignD(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignDFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignDFromGovHydroPID2Event.class)
  public void handle(UnAssignDFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignDFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignD(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignFeedbackSignalToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignFeedbackSignalToGovHydroPID2Event.class)
  public void handle(AssignFeedbackSignalToGovHydroPID2Event event) {
    LOGGER.info("handling AssignFeedbackSignalToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignFeedbackSignal(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignFeedbackSignalFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignFeedbackSignalFromGovHydroPID2Event.class)
  public void handle(UnAssignFeedbackSignalFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignFeedbackSignalFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignFeedbackSignal(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignG0ToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignG0ToGovHydroPID2Event.class)
  public void handle(AssignG0ToGovHydroPID2Event event) {
    LOGGER.info("handling AssignG0ToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignG0(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignG0FromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignG0FromGovHydroPID2Event.class)
  public void handle(UnAssignG0FromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignG0FromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignG0(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignG1ToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignG1ToGovHydroPID2Event.class)
  public void handle(AssignG1ToGovHydroPID2Event event) {
    LOGGER.info("handling AssignG1ToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignG1(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignG1FromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignG1FromGovHydroPID2Event.class)
  public void handle(UnAssignG1FromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignG1FromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignG1(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignG2ToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignG2ToGovHydroPID2Event.class)
  public void handle(AssignG2ToGovHydroPID2Event event) {
    LOGGER.info("handling AssignG2ToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignG2(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignG2FromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignG2FromGovHydroPID2Event.class)
  public void handle(UnAssignG2FromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignG2FromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignG2(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignGmaxToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignGmaxToGovHydroPID2Event.class)
  public void handle(AssignGmaxToGovHydroPID2Event event) {
    LOGGER.info("handling AssignGmaxToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignGmax(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignGmaxFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignGmaxFromGovHydroPID2Event.class)
  public void handle(UnAssignGmaxFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignGmaxFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignGmax(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignGminToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignGminToGovHydroPID2Event.class)
  public void handle(AssignGminToGovHydroPID2Event event) {
    LOGGER.info("handling AssignGminToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignGmin(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignGminFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignGminFromGovHydroPID2Event.class)
  public void handle(UnAssignGminFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignGminFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignGmin(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignKdToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignKdToGovHydroPID2Event.class)
  public void handle(AssignKdToGovHydroPID2Event event) {
    LOGGER.info("handling AssignKdToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignKd(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignKdFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignKdFromGovHydroPID2Event.class)
  public void handle(UnAssignKdFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignKdFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignKd(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignKiToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignKiToGovHydroPID2Event.class)
  public void handle(AssignKiToGovHydroPID2Event event) {
    LOGGER.info("handling AssignKiToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignKi(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignKiFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignKiFromGovHydroPID2Event.class)
  public void handle(UnAssignKiFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignKiFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignKi(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignKpToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignKpToGovHydroPID2Event.class)
  public void handle(AssignKpToGovHydroPID2Event event) {
    LOGGER.info("handling AssignKpToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignKp(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignKpFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignKpFromGovHydroPID2Event.class)
  public void handle(UnAssignKpFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignKpFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignKp(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroPID2Event.class)
  public void handle(AssignMwbaseToGovHydroPID2Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignMwbase(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroPID2Event.class)
  public void handle(UnAssignMwbaseFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignMwbase(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignP1ToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignP1ToGovHydroPID2Event.class)
  public void handle(AssignP1ToGovHydroPID2Event event) {
    LOGGER.info("handling AssignP1ToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignP1(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignP1FromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignP1FromGovHydroPID2Event.class)
  public void handle(UnAssignP1FromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignP1FromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignP1(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignP2ToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignP2ToGovHydroPID2Event.class)
  public void handle(AssignP2ToGovHydroPID2Event event) {
    LOGGER.info("handling AssignP2ToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignP2(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignP2FromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignP2FromGovHydroPID2Event.class)
  public void handle(UnAssignP2FromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignP2FromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignP2(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignP3ToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignP3ToGovHydroPID2Event.class)
  public void handle(AssignP3ToGovHydroPID2Event event) {
    LOGGER.info("handling AssignP3ToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignP3(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignP3FromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignP3FromGovHydroPID2Event.class)
  public void handle(UnAssignP3FromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignP3FromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignP3(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignRpermToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignRpermToGovHydroPID2Event.class)
  public void handle(AssignRpermToGovHydroPID2Event event) {
    LOGGER.info("handling AssignRpermToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignRperm(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignRpermFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignRpermFromGovHydroPID2Event.class)
  public void handle(UnAssignRpermFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignRpermFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignRperm(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignTaToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignTaToGovHydroPID2Event.class)
  public void handle(AssignTaToGovHydroPID2Event event) {
    LOGGER.info("handling AssignTaToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignTa(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignTaFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignTaFromGovHydroPID2Event.class)
  public void handle(UnAssignTaFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignTaFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignTa(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignTbToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignTbToGovHydroPID2Event.class)
  public void handle(AssignTbToGovHydroPID2Event event) {
    LOGGER.info("handling AssignTbToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignTb(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignTbFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignTbFromGovHydroPID2Event.class)
  public void handle(UnAssignTbFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignTbFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignTb(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignTregToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignTregToGovHydroPID2Event.class)
  public void handle(AssignTregToGovHydroPID2Event event) {
    LOGGER.info("handling AssignTregToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignTreg(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignTregFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignTregFromGovHydroPID2Event.class)
  public void handle(UnAssignTregFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignTregFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignTreg(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignTwToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignTwToGovHydroPID2Event.class)
  public void handle(AssignTwToGovHydroPID2Event event) {
    LOGGER.info("handling AssignTwToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignTw(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydroPID2Event.class)
  public void handle(UnAssignTwFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignTwFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignTw(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignVelmaxToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignVelmaxToGovHydroPID2Event.class)
  public void handle(AssignVelmaxToGovHydroPID2Event event) {
    LOGGER.info("handling AssignVelmaxToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignVelmax(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignVelmaxFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignVelmaxFromGovHydroPID2Event.class)
  public void handle(UnAssignVelmaxFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignVelmaxFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignVelmax(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event AssignVelminToGovHydroPID2Event
   */
  @EventHandler(payloadType = AssignVelminToGovHydroPID2Event.class)
  public void handle(AssignVelminToGovHydroPID2Event event) {
    LOGGER.info("handling AssignVelminToGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroPID2 entity = assignVelmin(event.getGovHydroPID2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /*
   * @param	event UnAssignVelminFromGovHydroPID2Event
   */
  @EventHandler(payloadType = UnAssignVelminFromGovHydroPID2Event.class)
  public void handle(UnAssignVelminFromGovHydroPID2Event event) {
    LOGGER.info("handling UnAssignVelminFromGovHydroPID2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroPID2 entity = unAssignVelmin(event.getGovHydroPID2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroPID2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroPID2(entity);
  }

  /**
   * Method to retrieve the GovHydroPID2 via an GovHydroPID2PrimaryKey.
   *
   * @param id Long
   * @return GovHydroPID2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroPID2 handle(FindGovHydroPID2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroPID2Id());
  }

  /**
   * Method to retrieve a collection of all GovHydroPID2s
   *
   * @param query FindAllGovHydroPID2Query
   * @return List<GovHydroPID2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroPID2> handle(FindAllGovHydroPID2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroPID2, but only if the id matches
   *
   * @param entity GovHydroPID2
   */
  protected void emitFindGovHydroPID2(GovHydroPID2 entity) {
    LOGGER.info("handling emitFindGovHydroPID2");

    queryUpdateEmitter.emit(
        FindGovHydroPID2Query.class,
        query -> query.getFilter().getGovHydroPID2Id().equals(entity.getGovHydroPID2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroPID2
   *
   * @param entity GovHydroPID2
   */
  protected void emitFindAllGovHydroPID2(GovHydroPID2 entity) {
    LOGGER.info("handling emitFindAllGovHydroPID2");

    queryUpdateEmitter.emit(FindAllGovHydroPID2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroPID2Projector.class.getName());
}
