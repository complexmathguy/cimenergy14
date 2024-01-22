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
 * Projector for GovHydro1 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovHydro1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovHydro1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydro1")
@Component("govHydro1-projector")
public class GovHydro1Projector extends GovHydro1EntityProjector {

  // core constructor
  public GovHydro1Projector(GovHydro1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydro1Event
   */
  @EventHandler(payloadType = CreateGovHydro1Event.class)
  public void handle(CreateGovHydro1Event event) {
    LOGGER.info("handling CreateGovHydro1Event - " + event);
    GovHydro1 entity = new GovHydro1();
    entity.setGovHydro1Id(event.getGovHydro1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UpdateGovHydro1Event
   */
  @EventHandler(payloadType = UpdateGovHydro1Event.class)
  public void handle(UpdateGovHydro1Event event) {
    LOGGER.info("handling UpdateGovHydro1Event - " + event);

    GovHydro1 entity = new GovHydro1();
    entity.setGovHydro1Id(event.getGovHydro1Id());
    entity.setAt(event.getAt());
    entity.setDturb(event.getDturb());
    entity.setGmax(event.getGmax());
    entity.setGmin(event.getGmin());
    entity.setHdam(event.getHdam());
    entity.setMwbase(event.getMwbase());
    entity.setQnl(event.getQnl());
    entity.setRperm(event.getRperm());
    entity.setRtemp(event.getRtemp());
    entity.setTf(event.getTf());
    entity.setTg(event.getTg());
    entity.setTr(event.getTr());
    entity.setTw(event.getTw());
    entity.setVelm(event.getVelm());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event DeleteGovHydro1Event
   */
  @EventHandler(payloadType = DeleteGovHydro1Event.class)
  public void handle(DeleteGovHydro1Event event) {
    LOGGER.info("handling DeleteGovHydro1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydro1 entity = delete(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignAtToGovHydro1Event
   */
  @EventHandler(payloadType = AssignAtToGovHydro1Event.class)
  public void handle(AssignAtToGovHydro1Event event) {
    LOGGER.info("handling AssignAtToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignAt(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignAtFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignAtFromGovHydro1Event.class)
  public void handle(UnAssignAtFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignAtFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignAt(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignDturbToGovHydro1Event
   */
  @EventHandler(payloadType = AssignDturbToGovHydro1Event.class)
  public void handle(AssignDturbToGovHydro1Event event) {
    LOGGER.info("handling AssignDturbToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignDturb(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignDturbFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignDturbFromGovHydro1Event.class)
  public void handle(UnAssignDturbFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignDturbFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignDturb(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignGmaxToGovHydro1Event
   */
  @EventHandler(payloadType = AssignGmaxToGovHydro1Event.class)
  public void handle(AssignGmaxToGovHydro1Event event) {
    LOGGER.info("handling AssignGmaxToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignGmax(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignGmaxFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignGmaxFromGovHydro1Event.class)
  public void handle(UnAssignGmaxFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignGmaxFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignGmax(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignGminToGovHydro1Event
   */
  @EventHandler(payloadType = AssignGminToGovHydro1Event.class)
  public void handle(AssignGminToGovHydro1Event event) {
    LOGGER.info("handling AssignGminToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignGmin(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignGminFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignGminFromGovHydro1Event.class)
  public void handle(UnAssignGminFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignGminFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignGmin(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignHdamToGovHydro1Event
   */
  @EventHandler(payloadType = AssignHdamToGovHydro1Event.class)
  public void handle(AssignHdamToGovHydro1Event event) {
    LOGGER.info("handling AssignHdamToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignHdam(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignHdamFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignHdamFromGovHydro1Event.class)
  public void handle(UnAssignHdamFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignHdamFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignHdam(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydro1Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydro1Event.class)
  public void handle(AssignMwbaseToGovHydro1Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignMwbase(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydro1Event.class)
  public void handle(UnAssignMwbaseFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignMwbase(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignQnlToGovHydro1Event
   */
  @EventHandler(payloadType = AssignQnlToGovHydro1Event.class)
  public void handle(AssignQnlToGovHydro1Event event) {
    LOGGER.info("handling AssignQnlToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignQnl(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignQnlFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignQnlFromGovHydro1Event.class)
  public void handle(UnAssignQnlFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignQnlFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignQnl(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignRpermToGovHydro1Event
   */
  @EventHandler(payloadType = AssignRpermToGovHydro1Event.class)
  public void handle(AssignRpermToGovHydro1Event event) {
    LOGGER.info("handling AssignRpermToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignRperm(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignRpermFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignRpermFromGovHydro1Event.class)
  public void handle(UnAssignRpermFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignRpermFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignRperm(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignRtempToGovHydro1Event
   */
  @EventHandler(payloadType = AssignRtempToGovHydro1Event.class)
  public void handle(AssignRtempToGovHydro1Event event) {
    LOGGER.info("handling AssignRtempToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignRtemp(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignRtempFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignRtempFromGovHydro1Event.class)
  public void handle(UnAssignRtempFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignRtempFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignRtemp(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignTfToGovHydro1Event
   */
  @EventHandler(payloadType = AssignTfToGovHydro1Event.class)
  public void handle(AssignTfToGovHydro1Event event) {
    LOGGER.info("handling AssignTfToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignTf(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignTfFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignTfFromGovHydro1Event.class)
  public void handle(UnAssignTfFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignTfFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignTf(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignTgToGovHydro1Event
   */
  @EventHandler(payloadType = AssignTgToGovHydro1Event.class)
  public void handle(AssignTgToGovHydro1Event event) {
    LOGGER.info("handling AssignTgToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignTg(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignTgFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignTgFromGovHydro1Event.class)
  public void handle(UnAssignTgFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignTgFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignTg(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignTrToGovHydro1Event
   */
  @EventHandler(payloadType = AssignTrToGovHydro1Event.class)
  public void handle(AssignTrToGovHydro1Event event) {
    LOGGER.info("handling AssignTrToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignTr(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignTrFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignTrFromGovHydro1Event.class)
  public void handle(UnAssignTrFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignTrFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignTr(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignTwToGovHydro1Event
   */
  @EventHandler(payloadType = AssignTwToGovHydro1Event.class)
  public void handle(AssignTwToGovHydro1Event event) {
    LOGGER.info("handling AssignTwToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignTw(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignTwFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignTwFromGovHydro1Event.class)
  public void handle(UnAssignTwFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignTwFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignTw(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event AssignVelmToGovHydro1Event
   */
  @EventHandler(payloadType = AssignVelmToGovHydro1Event.class)
  public void handle(AssignVelmToGovHydro1Event event) {
    LOGGER.info("handling AssignVelmToGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydro1 entity = assignVelm(event.getGovHydro1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /*
   * @param	event UnAssignVelmFromGovHydro1Event
   */
  @EventHandler(payloadType = UnAssignVelmFromGovHydro1Event.class)
  public void handle(UnAssignVelmFromGovHydro1Event event) {
    LOGGER.info("handling UnAssignVelmFromGovHydro1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydro1 entity = unAssignVelm(event.getGovHydro1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydro1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydro1(entity);
  }

  /**
   * Method to retrieve the GovHydro1 via an GovHydro1PrimaryKey.
   *
   * @param id Long
   * @return GovHydro1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydro1 handle(FindGovHydro1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydro1Id());
  }

  /**
   * Method to retrieve a collection of all GovHydro1s
   *
   * @param query FindAllGovHydro1Query
   * @return List<GovHydro1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydro1> handle(FindAllGovHydro1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydro1, but only if the id matches
   *
   * @param entity GovHydro1
   */
  protected void emitFindGovHydro1(GovHydro1 entity) {
    LOGGER.info("handling emitFindGovHydro1");

    queryUpdateEmitter.emit(
        FindGovHydro1Query.class,
        query -> query.getFilter().getGovHydro1Id().equals(entity.getGovHydro1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydro1
   *
   * @param entity GovHydro1
   */
  protected void emitFindAllGovHydro1(GovHydro1 entity) {
    LOGGER.info("handling emitFindAllGovHydro1");

    queryUpdateEmitter.emit(FindAllGovHydro1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydro1Projector.class.getName());
}
