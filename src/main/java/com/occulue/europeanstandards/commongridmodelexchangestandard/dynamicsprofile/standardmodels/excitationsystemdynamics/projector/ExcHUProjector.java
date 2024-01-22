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
 * Projector for ExcHU as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcHU are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcHUAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excHU")
@Component("excHU-projector")
public class ExcHUProjector extends ExcHUEntityProjector {

  // core constructor
  public ExcHUProjector(ExcHURepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcHUEvent
   */
  @EventHandler(payloadType = CreateExcHUEvent.class)
  public void handle(CreateExcHUEvent event) {
    LOGGER.info("handling CreateExcHUEvent - " + event);
    ExcHU entity = new ExcHU();
    entity.setExcHUId(event.getExcHUId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UpdateExcHUEvent
   */
  @EventHandler(payloadType = UpdateExcHUEvent.class)
  public void handle(UpdateExcHUEvent event) {
    LOGGER.info("handling UpdateExcHUEvent - " + event);

    ExcHU entity = new ExcHU();
    entity.setExcHUId(event.getExcHUId());
    entity.setAe(event.getAe());
    entity.setAi(event.getAi());
    entity.setAtr(event.getAtr());
    entity.setEmax(event.getEmax());
    entity.setEmin(event.getEmin());
    entity.setImax(event.getImax());
    entity.setImin(event.getImin());
    entity.setKe(event.getKe());
    entity.setKi(event.getKi());
    entity.setTe(event.getTe());
    entity.setTi(event.getTi());
    entity.setTr(event.getTr());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event DeleteExcHUEvent
   */
  @EventHandler(payloadType = DeleteExcHUEvent.class)
  public void handle(DeleteExcHUEvent event) {
    LOGGER.info("handling DeleteExcHUEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcHU entity = delete(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignAeToExcHUEvent
   */
  @EventHandler(payloadType = AssignAeToExcHUEvent.class)
  public void handle(AssignAeToExcHUEvent event) {
    LOGGER.info("handling AssignAeToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignAe(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignAeFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignAeFromExcHUEvent.class)
  public void handle(UnAssignAeFromExcHUEvent event) {
    LOGGER.info("handling UnAssignAeFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignAe(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignAiToExcHUEvent
   */
  @EventHandler(payloadType = AssignAiToExcHUEvent.class)
  public void handle(AssignAiToExcHUEvent event) {
    LOGGER.info("handling AssignAiToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignAi(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignAiFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignAiFromExcHUEvent.class)
  public void handle(UnAssignAiFromExcHUEvent event) {
    LOGGER.info("handling UnAssignAiFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignAi(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignAtrToExcHUEvent
   */
  @EventHandler(payloadType = AssignAtrToExcHUEvent.class)
  public void handle(AssignAtrToExcHUEvent event) {
    LOGGER.info("handling AssignAtrToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignAtr(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignAtrFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignAtrFromExcHUEvent.class)
  public void handle(UnAssignAtrFromExcHUEvent event) {
    LOGGER.info("handling UnAssignAtrFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignAtr(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignEmaxToExcHUEvent
   */
  @EventHandler(payloadType = AssignEmaxToExcHUEvent.class)
  public void handle(AssignEmaxToExcHUEvent event) {
    LOGGER.info("handling AssignEmaxToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignEmax(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignEmaxFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignEmaxFromExcHUEvent.class)
  public void handle(UnAssignEmaxFromExcHUEvent event) {
    LOGGER.info("handling UnAssignEmaxFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignEmax(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignEminToExcHUEvent
   */
  @EventHandler(payloadType = AssignEminToExcHUEvent.class)
  public void handle(AssignEminToExcHUEvent event) {
    LOGGER.info("handling AssignEminToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignEmin(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignEminFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignEminFromExcHUEvent.class)
  public void handle(UnAssignEminFromExcHUEvent event) {
    LOGGER.info("handling UnAssignEminFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignEmin(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignImaxToExcHUEvent
   */
  @EventHandler(payloadType = AssignImaxToExcHUEvent.class)
  public void handle(AssignImaxToExcHUEvent event) {
    LOGGER.info("handling AssignImaxToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignImax(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignImaxFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignImaxFromExcHUEvent.class)
  public void handle(UnAssignImaxFromExcHUEvent event) {
    LOGGER.info("handling UnAssignImaxFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignImax(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignIminToExcHUEvent
   */
  @EventHandler(payloadType = AssignIminToExcHUEvent.class)
  public void handle(AssignIminToExcHUEvent event) {
    LOGGER.info("handling AssignIminToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignImin(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignIminFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignIminFromExcHUEvent.class)
  public void handle(UnAssignIminFromExcHUEvent event) {
    LOGGER.info("handling UnAssignIminFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignImin(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignKeToExcHUEvent
   */
  @EventHandler(payloadType = AssignKeToExcHUEvent.class)
  public void handle(AssignKeToExcHUEvent event) {
    LOGGER.info("handling AssignKeToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignKe(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignKeFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcHUEvent.class)
  public void handle(UnAssignKeFromExcHUEvent event) {
    LOGGER.info("handling UnAssignKeFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignKe(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignKiToExcHUEvent
   */
  @EventHandler(payloadType = AssignKiToExcHUEvent.class)
  public void handle(AssignKiToExcHUEvent event) {
    LOGGER.info("handling AssignKiToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignKi(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignKiFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcHUEvent.class)
  public void handle(UnAssignKiFromExcHUEvent event) {
    LOGGER.info("handling UnAssignKiFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignKi(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignTeToExcHUEvent
   */
  @EventHandler(payloadType = AssignTeToExcHUEvent.class)
  public void handle(AssignTeToExcHUEvent event) {
    LOGGER.info("handling AssignTeToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignTe(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignTeFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcHUEvent.class)
  public void handle(UnAssignTeFromExcHUEvent event) {
    LOGGER.info("handling UnAssignTeFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignTe(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignTiToExcHUEvent
   */
  @EventHandler(payloadType = AssignTiToExcHUEvent.class)
  public void handle(AssignTiToExcHUEvent event) {
    LOGGER.info("handling AssignTiToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignTi(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignTiFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignTiFromExcHUEvent.class)
  public void handle(UnAssignTiFromExcHUEvent event) {
    LOGGER.info("handling UnAssignTiFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignTi(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event AssignTrToExcHUEvent
   */
  @EventHandler(payloadType = AssignTrToExcHUEvent.class)
  public void handle(AssignTrToExcHUEvent event) {
    LOGGER.info("handling AssignTrToExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcHU entity = assignTr(event.getExcHUId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /*
   * @param	event UnAssignTrFromExcHUEvent
   */
  @EventHandler(payloadType = UnAssignTrFromExcHUEvent.class)
  public void handle(UnAssignTrFromExcHUEvent event) {
    LOGGER.info("handling UnAssignTrFromExcHUEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcHU entity = unAssignTr(event.getExcHUId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcHU(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcHU(entity);
  }

  /**
   * Method to retrieve the ExcHU via an ExcHUPrimaryKey.
   *
   * @param id Long
   * @return ExcHU
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcHU handle(FindExcHUQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcHUId());
  }

  /**
   * Method to retrieve a collection of all ExcHUs
   *
   * @param query FindAllExcHUQuery
   * @return List<ExcHU>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcHU> handle(FindAllExcHUQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcHU, but only if the id matches
   *
   * @param entity ExcHU
   */
  protected void emitFindExcHU(ExcHU entity) {
    LOGGER.info("handling emitFindExcHU");

    queryUpdateEmitter.emit(
        FindExcHUQuery.class,
        query -> query.getFilter().getExcHUId().equals(entity.getExcHUId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcHU
   *
   * @param entity ExcHU
   */
  protected void emitFindAllExcHU(ExcHU entity) {
    LOGGER.info("handling emitFindAllExcHU");

    queryUpdateEmitter.emit(FindAllExcHUQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcHUProjector.class.getName());
}
