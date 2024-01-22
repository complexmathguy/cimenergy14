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
 * Projector for GovHydroIEEE0 as outlined for the CQRS pattern. All event handling and query
 * handling related to GovHydroIEEE0 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by GovHydroIEEE0Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("govHydroIEEE0")
@Component("govHydroIEEE0-projector")
public class GovHydroIEEE0Projector extends GovHydroIEEE0EntityProjector {

  // core constructor
  public GovHydroIEEE0Projector(
      GovHydroIEEE0Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateGovHydroIEEE0Event
   */
  @EventHandler(payloadType = CreateGovHydroIEEE0Event.class)
  public void handle(CreateGovHydroIEEE0Event event) {
    LOGGER.info("handling CreateGovHydroIEEE0Event - " + event);
    GovHydroIEEE0 entity = new GovHydroIEEE0();
    entity.setGovHydroIEEE0Id(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UpdateGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UpdateGovHydroIEEE0Event.class)
  public void handle(UpdateGovHydroIEEE0Event event) {
    LOGGER.info("handling UpdateGovHydroIEEE0Event - " + event);

    GovHydroIEEE0 entity = new GovHydroIEEE0();
    entity.setGovHydroIEEE0Id(event.getGovHydroIEEE0Id());
    entity.setK(event.getK());
    entity.setMwbase(event.getMwbase());
    entity.setPmax(event.getPmax());
    entity.setPmin(event.getPmin());
    entity.setT1(event.getT1());
    entity.setT2(event.getT2());
    entity.setT3(event.getT3());
    entity.setT4(event.getT4());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event DeleteGovHydroIEEE0Event
   */
  @EventHandler(payloadType = DeleteGovHydroIEEE0Event.class)
  public void handle(DeleteGovHydroIEEE0Event event) {
    LOGGER.info("handling DeleteGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    GovHydroIEEE0 entity = delete(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignKToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignKToGovHydroIEEE0Event.class)
  public void handle(AssignKToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignKToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignK(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignKFromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignKFromGovHydroIEEE0Event.class)
  public void handle(UnAssignKFromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignKFromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignK(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignMwbaseToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignMwbaseToGovHydroIEEE0Event.class)
  public void handle(AssignMwbaseToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignMwbaseToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignMwbase(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignMwbaseFromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignMwbaseFromGovHydroIEEE0Event.class)
  public void handle(UnAssignMwbaseFromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignMwbaseFromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignMwbase(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignPmaxToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignPmaxToGovHydroIEEE0Event.class)
  public void handle(AssignPmaxToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignPmaxToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignPmax(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignPmaxFromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignPmaxFromGovHydroIEEE0Event.class)
  public void handle(UnAssignPmaxFromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignPmaxFromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignPmax(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignPminToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignPminToGovHydroIEEE0Event.class)
  public void handle(AssignPminToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignPminToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignPmin(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignPminFromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignPminFromGovHydroIEEE0Event.class)
  public void handle(UnAssignPminFromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignPminFromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignPmin(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignT1ToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignT1ToGovHydroIEEE0Event.class)
  public void handle(AssignT1ToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignT1ToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignT1(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignT1FromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignT1FromGovHydroIEEE0Event.class)
  public void handle(UnAssignT1FromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignT1FromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignT1(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignT2ToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignT2ToGovHydroIEEE0Event.class)
  public void handle(AssignT2ToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignT2ToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignT2(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignT2FromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignT2FromGovHydroIEEE0Event.class)
  public void handle(UnAssignT2FromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignT2FromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignT2(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignT3ToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignT3ToGovHydroIEEE0Event.class)
  public void handle(AssignT3ToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignT3ToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignT3(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignT3FromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignT3FromGovHydroIEEE0Event.class)
  public void handle(UnAssignT3FromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignT3FromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignT3(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event AssignT4ToGovHydroIEEE0Event
   */
  @EventHandler(payloadType = AssignT4ToGovHydroIEEE0Event.class)
  public void handle(AssignT4ToGovHydroIEEE0Event event) {
    LOGGER.info("handling AssignT4ToGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    GovHydroIEEE0 entity = assignT4(event.getGovHydroIEEE0Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /*
   * @param	event UnAssignT4FromGovHydroIEEE0Event
   */
  @EventHandler(payloadType = UnAssignT4FromGovHydroIEEE0Event.class)
  public void handle(UnAssignT4FromGovHydroIEEE0Event event) {
    LOGGER.info("handling UnAssignT4FromGovHydroIEEE0Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    GovHydroIEEE0 entity = unAssignT4(event.getGovHydroIEEE0Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindGovHydroIEEE0(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllGovHydroIEEE0(entity);
  }

  /**
   * Method to retrieve the GovHydroIEEE0 via an GovHydroIEEE0PrimaryKey.
   *
   * @param id Long
   * @return GovHydroIEEE0
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public GovHydroIEEE0 handle(FindGovHydroIEEE0Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getGovHydroIEEE0Id());
  }

  /**
   * Method to retrieve a collection of all GovHydroIEEE0s
   *
   * @param query FindAllGovHydroIEEE0Query
   * @return List<GovHydroIEEE0>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<GovHydroIEEE0> handle(FindAllGovHydroIEEE0Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindGovHydroIEEE0, but only if the id matches
   *
   * @param entity GovHydroIEEE0
   */
  protected void emitFindGovHydroIEEE0(GovHydroIEEE0 entity) {
    LOGGER.info("handling emitFindGovHydroIEEE0");

    queryUpdateEmitter.emit(
        FindGovHydroIEEE0Query.class,
        query -> query.getFilter().getGovHydroIEEE0Id().equals(entity.getGovHydroIEEE0Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllGovHydroIEEE0
   *
   * @param entity GovHydroIEEE0
   */
  protected void emitFindAllGovHydroIEEE0(GovHydroIEEE0 entity) {
    LOGGER.info("handling emitFindAllGovHydroIEEE0");

    queryUpdateEmitter.emit(FindAllGovHydroIEEE0Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(GovHydroIEEE0Projector.class.getName());
}
