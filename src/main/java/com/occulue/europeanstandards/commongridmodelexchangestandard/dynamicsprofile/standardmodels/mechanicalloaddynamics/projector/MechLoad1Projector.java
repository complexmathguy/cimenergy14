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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.mechanicalloaddynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for MechLoad1 as outlined for the CQRS pattern. All event handling and query handling
 * related to MechLoad1 are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by MechLoad1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("mechLoad1")
@Component("mechLoad1-projector")
public class MechLoad1Projector extends MechLoad1EntityProjector {

  // core constructor
  public MechLoad1Projector(MechLoad1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateMechLoad1Event
   */
  @EventHandler(payloadType = CreateMechLoad1Event.class)
  public void handle(CreateMechLoad1Event event) {
    LOGGER.info("handling CreateMechLoad1Event - " + event);
    MechLoad1 entity = new MechLoad1();
    entity.setMechLoad1Id(event.getMechLoad1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event UpdateMechLoad1Event
   */
  @EventHandler(payloadType = UpdateMechLoad1Event.class)
  public void handle(UpdateMechLoad1Event event) {
    LOGGER.info("handling UpdateMechLoad1Event - " + event);

    MechLoad1 entity = new MechLoad1();
    entity.setMechLoad1Id(event.getMechLoad1Id());
    entity.setA(event.getA());
    entity.setB(event.getB());
    entity.setD(event.getD());
    entity.setE(event.getE());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event DeleteMechLoad1Event
   */
  @EventHandler(payloadType = DeleteMechLoad1Event.class)
  public void handle(DeleteMechLoad1Event event) {
    LOGGER.info("handling DeleteMechLoad1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    MechLoad1 entity = delete(event.getMechLoad1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event AssignAToMechLoad1Event
   */
  @EventHandler(payloadType = AssignAToMechLoad1Event.class)
  public void handle(AssignAToMechLoad1Event event) {
    LOGGER.info("handling AssignAToMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    MechLoad1 entity = assignA(event.getMechLoad1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event UnAssignAFromMechLoad1Event
   */
  @EventHandler(payloadType = UnAssignAFromMechLoad1Event.class)
  public void handle(UnAssignAFromMechLoad1Event event) {
    LOGGER.info("handling UnAssignAFromMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    MechLoad1 entity = unAssignA(event.getMechLoad1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event AssignBToMechLoad1Event
   */
  @EventHandler(payloadType = AssignBToMechLoad1Event.class)
  public void handle(AssignBToMechLoad1Event event) {
    LOGGER.info("handling AssignBToMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    MechLoad1 entity = assignB(event.getMechLoad1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event UnAssignBFromMechLoad1Event
   */
  @EventHandler(payloadType = UnAssignBFromMechLoad1Event.class)
  public void handle(UnAssignBFromMechLoad1Event event) {
    LOGGER.info("handling UnAssignBFromMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    MechLoad1 entity = unAssignB(event.getMechLoad1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event AssignDToMechLoad1Event
   */
  @EventHandler(payloadType = AssignDToMechLoad1Event.class)
  public void handle(AssignDToMechLoad1Event event) {
    LOGGER.info("handling AssignDToMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    MechLoad1 entity = assignD(event.getMechLoad1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event UnAssignDFromMechLoad1Event
   */
  @EventHandler(payloadType = UnAssignDFromMechLoad1Event.class)
  public void handle(UnAssignDFromMechLoad1Event event) {
    LOGGER.info("handling UnAssignDFromMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    MechLoad1 entity = unAssignD(event.getMechLoad1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event AssignEToMechLoad1Event
   */
  @EventHandler(payloadType = AssignEToMechLoad1Event.class)
  public void handle(AssignEToMechLoad1Event event) {
    LOGGER.info("handling AssignEToMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    MechLoad1 entity = assignE(event.getMechLoad1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /*
   * @param	event UnAssignEFromMechLoad1Event
   */
  @EventHandler(payloadType = UnAssignEFromMechLoad1Event.class)
  public void handle(UnAssignEFromMechLoad1Event event) {
    LOGGER.info("handling UnAssignEFromMechLoad1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    MechLoad1 entity = unAssignE(event.getMechLoad1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindMechLoad1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllMechLoad1(entity);
  }

  /**
   * Method to retrieve the MechLoad1 via an MechLoad1PrimaryKey.
   *
   * @param id Long
   * @return MechLoad1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public MechLoad1 handle(FindMechLoad1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getMechLoad1Id());
  }

  /**
   * Method to retrieve a collection of all MechLoad1s
   *
   * @param query FindAllMechLoad1Query
   * @return List<MechLoad1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<MechLoad1> handle(FindAllMechLoad1Query query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindMechLoad1, but only if the id matches
   *
   * @param entity MechLoad1
   */
  protected void emitFindMechLoad1(MechLoad1 entity) {
    LOGGER.info("handling emitFindMechLoad1");

    queryUpdateEmitter.emit(
        FindMechLoad1Query.class,
        query -> query.getFilter().getMechLoad1Id().equals(entity.getMechLoad1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllMechLoad1
   *
   * @param entity MechLoad1
   */
  protected void emitFindAllMechLoad1(MechLoad1 entity) {
    LOGGER.info("handling emitFindAllMechLoad1");

    queryUpdateEmitter.emit(FindAllMechLoad1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(MechLoad1Projector.class.getName());
}
