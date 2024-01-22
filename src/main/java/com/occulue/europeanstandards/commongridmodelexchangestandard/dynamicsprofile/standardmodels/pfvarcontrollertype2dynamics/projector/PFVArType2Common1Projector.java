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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.pfvarcontrollertype2dynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for PFVArType2Common1 as outlined for the CQRS pattern. All event handling and query
 * handling related to PFVArType2Common1 are invoked here and dispersed as an event to be handled
 * elsewhere.
 *
 * <p>Commands are handled by PFVArType2Common1Aggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("pFVArType2Common1")
@Component("pFVArType2Common1-projector")
public class PFVArType2Common1Projector extends PFVArType2Common1EntityProjector {

  // core constructor
  public PFVArType2Common1Projector(
      PFVArType2Common1Repository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreatePFVArType2Common1Event
   */
  @EventHandler(payloadType = CreatePFVArType2Common1Event.class)
  public void handle(CreatePFVArType2Common1Event event) {
    LOGGER.info("handling CreatePFVArType2Common1Event - " + event);
    PFVArType2Common1 entity = new PFVArType2Common1();
    entity.setPFVArType2Common1Id(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event UpdatePFVArType2Common1Event
   */
  @EventHandler(payloadType = UpdatePFVArType2Common1Event.class)
  public void handle(UpdatePFVArType2Common1Event event) {
    LOGGER.info("handling UpdatePFVArType2Common1Event - " + event);

    PFVArType2Common1 entity = new PFVArType2Common1();
    entity.setPFVArType2Common1Id(event.getPFVArType2Common1Id());
    entity.setJ(event.getJ());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setMax(event.getMax());
    entity.setRef(event.getRef());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event DeletePFVArType2Common1Event
   */
  @EventHandler(payloadType = DeletePFVArType2Common1Event.class)
  public void handle(DeletePFVArType2Common1Event event) {
    LOGGER.info("handling DeletePFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    PFVArType2Common1 entity = delete(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event AssignJToPFVArType2Common1Event
   */
  @EventHandler(payloadType = AssignJToPFVArType2Common1Event.class)
  public void handle(AssignJToPFVArType2Common1Event event) {
    LOGGER.info("handling AssignJToPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2Common1 entity = assignJ(event.getPFVArType2Common1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event UnAssignJFromPFVArType2Common1Event
   */
  @EventHandler(payloadType = UnAssignJFromPFVArType2Common1Event.class)
  public void handle(UnAssignJFromPFVArType2Common1Event event) {
    LOGGER.info("handling UnAssignJFromPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2Common1 entity = unAssignJ(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event AssignKiToPFVArType2Common1Event
   */
  @EventHandler(payloadType = AssignKiToPFVArType2Common1Event.class)
  public void handle(AssignKiToPFVArType2Common1Event event) {
    LOGGER.info("handling AssignKiToPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2Common1 entity = assignKi(event.getPFVArType2Common1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event UnAssignKiFromPFVArType2Common1Event
   */
  @EventHandler(payloadType = UnAssignKiFromPFVArType2Common1Event.class)
  public void handle(UnAssignKiFromPFVArType2Common1Event event) {
    LOGGER.info("handling UnAssignKiFromPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2Common1 entity = unAssignKi(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event AssignKpToPFVArType2Common1Event
   */
  @EventHandler(payloadType = AssignKpToPFVArType2Common1Event.class)
  public void handle(AssignKpToPFVArType2Common1Event event) {
    LOGGER.info("handling AssignKpToPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2Common1 entity = assignKp(event.getPFVArType2Common1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event UnAssignKpFromPFVArType2Common1Event
   */
  @EventHandler(payloadType = UnAssignKpFromPFVArType2Common1Event.class)
  public void handle(UnAssignKpFromPFVArType2Common1Event event) {
    LOGGER.info("handling UnAssignKpFromPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2Common1 entity = unAssignKp(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event AssignMaxToPFVArType2Common1Event
   */
  @EventHandler(payloadType = AssignMaxToPFVArType2Common1Event.class)
  public void handle(AssignMaxToPFVArType2Common1Event event) {
    LOGGER.info("handling AssignMaxToPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2Common1 entity = assignMax(event.getPFVArType2Common1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event UnAssignMaxFromPFVArType2Common1Event
   */
  @EventHandler(payloadType = UnAssignMaxFromPFVArType2Common1Event.class)
  public void handle(UnAssignMaxFromPFVArType2Common1Event event) {
    LOGGER.info("handling UnAssignMaxFromPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2Common1 entity = unAssignMax(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event AssignRefToPFVArType2Common1Event
   */
  @EventHandler(payloadType = AssignRefToPFVArType2Common1Event.class)
  public void handle(AssignRefToPFVArType2Common1Event event) {
    LOGGER.info("handling AssignRefToPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    PFVArType2Common1 entity = assignRef(event.getPFVArType2Common1Id(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /*
   * @param	event UnAssignRefFromPFVArType2Common1Event
   */
  @EventHandler(payloadType = UnAssignRefFromPFVArType2Common1Event.class)
  public void handle(UnAssignRefFromPFVArType2Common1Event event) {
    LOGGER.info("handling UnAssignRefFromPFVArType2Common1Event - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    PFVArType2Common1 entity = unAssignRef(event.getPFVArType2Common1Id());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindPFVArType2Common1(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllPFVArType2Common1(entity);
  }

  /**
   * Method to retrieve the PFVArType2Common1 via an PFVArType2Common1PrimaryKey.
   *
   * @param id Long
   * @return PFVArType2Common1
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public PFVArType2Common1 handle(FindPFVArType2Common1Query query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getPFVArType2Common1Id());
  }

  /**
   * Method to retrieve a collection of all PFVArType2Common1s
   *
   * @param query FindAllPFVArType2Common1Query
   * @return List<PFVArType2Common1>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<PFVArType2Common1> handle(FindAllPFVArType2Common1Query query)
      throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindPFVArType2Common1, but only if the id matches
   *
   * @param entity PFVArType2Common1
   */
  protected void emitFindPFVArType2Common1(PFVArType2Common1 entity) {
    LOGGER.info("handling emitFindPFVArType2Common1");

    queryUpdateEmitter.emit(
        FindPFVArType2Common1Query.class,
        query -> query.getFilter().getPFVArType2Common1Id().equals(entity.getPFVArType2Common1Id()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllPFVArType2Common1
   *
   * @param entity PFVArType2Common1
   */
  protected void emitFindAllPFVArType2Common1(PFVArType2Common1 entity) {
    LOGGER.info("handling emitFindAllPFVArType2Common1");

    queryUpdateEmitter.emit(FindAllPFVArType2Common1Query.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(PFVArType2Common1Projector.class.getName());
}
