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
 * Projector for GovSteam2 as outlined for the CQRS pattern. All event handling and query handling
 * related to GovSteam2 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by GovSteam2Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govSteam2")
@Component("govSteam2-projector")
public class GovSteam2Projector extends GovSteam2EntityProjector {

  // core constructor
  public GovSteam2Projector(GovSteam2Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovSteam2Event
   */
  @EventHandler(payloadType = CreateGovSteam2Event.class)
  public void handle(CreateGovSteam2Event event) {
    LOGGER.info("handling CreateGovSteam2Event - " + event);
    GovSteam2 entity = new GovSteam2();
    entity.setGovSteam2Id(event.getGovSteam2Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UpdateGovSteam2Event
   */
  @EventHandler(payloadType = UpdateGovSteam2Event.class)
  public void handle(UpdateGovSteam2Event event) {
    LOGGER.info("handling UpdateGovSteam2Event - " + event);

    GovSteam2 entity = new GovSteam2();
    entity.setGovSteam2Id(event.getGovSteam2Id());
    entity.setDbf(event.getDbf());
    entity.setK(event.getK());
    entity.setMnef(event.getMnef());
    entity.setMxef(event.getMxef());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event DeleteGovSteam2Event
   */
  @EventHandler(payloadType = DeleteGovSteam2Event.class)
  public void handle(DeleteGovSteam2Event event) {
    LOGGER.info("handling DeleteGovSteam2Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovSteam2 entity = delete(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignDbfToGovSteam2Event
   */
  @EventHandler(payloadType = AssignDbfToGovSteam2Event.class)
  public void handle(AssignDbfToGovSteam2Event event) {
    LOGGER.info("handling AssignDbfToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignDbf(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignDbfFromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignDbfFromGovSteam2Event.class)
  public void handle(UnAssignDbfFromGovSteam2Event event) {
    LOGGER.info("handling UnAssignDbfFromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignDbf(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignKToGovSteam2Event
   */
  @EventHandler(payloadType = AssignKToGovSteam2Event.class)
  public void handle(AssignKToGovSteam2Event event) {
    LOGGER.info("handling AssignKToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignK(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignKFromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignKFromGovSteam2Event.class)
  public void handle(UnAssignKFromGovSteam2Event event) {
    LOGGER.info("handling UnAssignKFromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignK(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignMnefToGovSteam2Event
   */
  @EventHandler(payloadType = AssignMnefToGovSteam2Event.class)
  public void handle(AssignMnefToGovSteam2Event event) {
    LOGGER.info("handling AssignMnefToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignMnef(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignMnefFromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignMnefFromGovSteam2Event.class)
  public void handle(UnAssignMnefFromGovSteam2Event event) {
    LOGGER.info("handling UnAssignMnefFromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignMnef(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignMxefToGovSteam2Event
   */
  @EventHandler(payloadType = AssignMxefToGovSteam2Event.class)
  public void handle(AssignMxefToGovSteam2Event event) {
    LOGGER.info("handling AssignMxefToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignMxef(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignMxefFromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignMxefFromGovSteam2Event.class)
  public void handle(UnAssignMxefFromGovSteam2Event event) {
    LOGGER.info("handling UnAssignMxefFromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignMxef(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignPmaxToGovSteam2Event
   */
  @EventHandler(payloadType = AssignPmaxToGovSteam2Event.class)
  public void handle(AssignPmaxToGovSteam2Event event) {
    LOGGER.info("handling AssignPmaxToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignPmax(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovSteam2Event.class)
  public void handle(UnAssignPmaxFromGovSteam2Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignPmax(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignPminToGovSteam2Event
   */
  @EventHandler(payloadType = AssignPminToGovSteam2Event.class)
  public void handle(AssignPminToGovSteam2Event event) {
    LOGGER.info("handling AssignPminToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignPmin(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignPminFromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovSteam2Event.class)
  public void handle(UnAssignPminFromGovSteam2Event event) {
    LOGGER.info("handling UnAssignPminFromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignPmin(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignT1ToGovSteam2Event
   */
  @EventHandler(payloadType = AssignT1ToGovSteam2Event.class)
  public void handle(AssignT1ToGovSteam2Event event) {
    LOGGER.info("handling AssignT1ToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignT1(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignT1FromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovSteam2Event.class)
  public void handle(UnAssignT1FromGovSteam2Event event) {
    LOGGER.info("handling UnAssignT1FromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignT1(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event AssignT2ToGovSteam2Event
   */
  @EventHandler(payloadType = AssignT2ToGovSteam2Event.class)
  public void handle(AssignT2ToGovSteam2Event event) {
    LOGGER.info("handling AssignT2ToGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovSteam2 entity = assignT2(event.getGovSteam2Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /*
   * @param	event UnAssignT2FromGovSteam2Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovSteam2Event.class)
  public void handle(UnAssignT2FromGovSteam2Event event) {
    LOGGER.info("handling UnAssignT2FromGovSteam2Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovSteam2 entity = unAssignT2(event.getGovSteam2Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovSteam2(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovSteam2(entity);
  }

  /**
   * Method to retrieve the GovSteam2 via an GovSteam2PrimaryKey.
   *
   * @param id Long
   * @return GovSteam2
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovSteam2 handle(FindGovSteam2Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovSteam2Id());
  }

  /**
   * Method to retrieve a collection of all GovSteam2s
   *
   * @param query FindAllGovSteam2Query
   * @return List<GovSteam2>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovSteam2> handle(FindAllGovSteam2Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovSteam2, but only if the id matches
   *
   * @param entity GovSteam2
   */
  protected void emitFindGovSteam2(GovSteam2 entity) {
    LOGGER.info("handling emitFindGovSteam2");

    queryUpdateEmitter.emit(
        FindGovSteam2Query.class,
        query -> query.getFilter().getGovSteam2Id().equals(entity.getGovSteam2Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovSteam2
   *
   * @param entity GovSteam2
   */
  protected void emitFindAllGovSteam2(GovSteam2 entity) {
    LOGGER.info("handling emitFindAllGovSteam2");

    queryUpdateEmitter.emit(FindAllGovSteam2Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovSteam2Projector.class.getName());
}
