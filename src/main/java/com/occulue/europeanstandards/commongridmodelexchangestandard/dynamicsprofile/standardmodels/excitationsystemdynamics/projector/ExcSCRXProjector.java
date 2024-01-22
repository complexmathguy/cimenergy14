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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.repository.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.logging.Logger;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.queryhandling.QueryUpdateEmitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for ExcSCRX as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcSCRX are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcSCRXAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excSCRX")
@Component("excSCRX-projector")
public class ExcSCRXProjector extends ExcSCRXEntityProjector {

  // core constructor
  public ExcSCRXProjector(ExcSCRXRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcSCRXEvent
   */
  @EventHandler(payloadType = CreateExcSCRXEvent.class)
  public void handle(CreateExcSCRXEvent event) {
    LOGGER.info("handling CreateExcSCRXEvent - " + event);
    ExcSCRX entity = new ExcSCRX();
    entity.setExcSCRXId(event.getExcSCRXId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UpdateExcSCRXEvent
   */
  @EventHandler(payloadType = UpdateExcSCRXEvent.class)
  public void handle(UpdateExcSCRXEvent event) {
    LOGGER.info("handling UpdateExcSCRXEvent - " + event);

    ExcSCRX entity = new ExcSCRX();
    entity.setExcSCRXId(event.getExcSCRXId());
    entity.setCswitch(event.getCswitch());
    entity.setEmax(event.getEmax());
    entity.setEmin(event.getEmin());
    entity.setK(event.getK());
    entity.setRcrfd(event.getRcrfd());
    entity.setTatb(event.getTatb());
    entity.setTb(event.getTb());
    entity.setTe(event.getTe());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event DeleteExcSCRXEvent
   */
  @EventHandler(payloadType = DeleteExcSCRXEvent.class)
  public void handle(DeleteExcSCRXEvent event) {
    LOGGER.info("handling DeleteExcSCRXEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcSCRX entity = delete(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignCswitchToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignCswitchToExcSCRXEvent.class)
  public void handle(AssignCswitchToExcSCRXEvent event) {
    LOGGER.info("handling AssignCswitchToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignCswitch(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignCswitchFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignCswitchFromExcSCRXEvent.class)
  public void handle(UnAssignCswitchFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignCswitchFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignCswitch(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignEmaxToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignEmaxToExcSCRXEvent.class)
  public void handle(AssignEmaxToExcSCRXEvent event) {
    LOGGER.info("handling AssignEmaxToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignEmax(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignEmaxFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignEmaxFromExcSCRXEvent.class)
  public void handle(UnAssignEmaxFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignEmaxFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignEmax(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignEminToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignEminToExcSCRXEvent.class)
  public void handle(AssignEminToExcSCRXEvent event) {
    LOGGER.info("handling AssignEminToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignEmin(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignEminFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignEminFromExcSCRXEvent.class)
  public void handle(UnAssignEminFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignEminFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignEmin(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignKToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignKToExcSCRXEvent.class)
  public void handle(AssignKToExcSCRXEvent event) {
    LOGGER.info("handling AssignKToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignK(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignKFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignKFromExcSCRXEvent.class)
  public void handle(UnAssignKFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignKFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignK(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignRcrfdToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignRcrfdToExcSCRXEvent.class)
  public void handle(AssignRcrfdToExcSCRXEvent event) {
    LOGGER.info("handling AssignRcrfdToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignRcrfd(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignRcrfdFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignRcrfdFromExcSCRXEvent.class)
  public void handle(UnAssignRcrfdFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignRcrfdFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignRcrfd(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignTatbToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignTatbToExcSCRXEvent.class)
  public void handle(AssignTatbToExcSCRXEvent event) {
    LOGGER.info("handling AssignTatbToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignTatb(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignTatbFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignTatbFromExcSCRXEvent.class)
  public void handle(UnAssignTatbFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignTatbFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignTatb(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignTbToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignTbToExcSCRXEvent.class)
  public void handle(AssignTbToExcSCRXEvent event) {
    LOGGER.info("handling AssignTbToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignTb(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignTbFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcSCRXEvent.class)
  public void handle(UnAssignTbFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignTbFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignTb(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event AssignTeToExcSCRXEvent
   */
  @EventHandler(payloadType = AssignTeToExcSCRXEvent.class)
  public void handle(AssignTeToExcSCRXEvent event) {
    LOGGER.info("handling AssignTeToExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSCRX entity = assignTe(event.getExcSCRXId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /*
   * @param	event UnAssignTeFromExcSCRXEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcSCRXEvent.class)
  public void handle(UnAssignTeFromExcSCRXEvent event) {
    LOGGER.info("handling UnAssignTeFromExcSCRXEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSCRX entity = unAssignTe(event.getExcSCRXId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSCRX(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSCRX(entity);
  }

  /**
   * Method to retrieve the ExcSCRX via an ExcSCRXPrimaryKey.
   *
   * @param id Long
   * @return ExcSCRX
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcSCRX handle(FindExcSCRXQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcSCRXId());
  }

  /**
   * Method to retrieve a collection of all ExcSCRXs
   *
   * @param query FindAllExcSCRXQuery
   * @return List<ExcSCRX>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcSCRX> handle(FindAllExcSCRXQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcSCRX, but only if the id matches
   *
   * @param entity ExcSCRX
   */
  protected void emitFindExcSCRX(ExcSCRX entity) {
    LOGGER.info("handling emitFindExcSCRX");

    queryUpdateEmitter.emit(
        FindExcSCRXQuery.class,
        query -> query.getFilter().getExcSCRXId().equals(entity.getExcSCRXId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcSCRX
   *
   * @param entity ExcSCRX
   */
  protected void emitFindAllExcSCRX(ExcSCRX entity) {
    LOGGER.info("handling emitFindAllExcSCRX");

    queryUpdateEmitter.emit(FindAllExcSCRXQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcSCRXProjector.class.getName());
}
