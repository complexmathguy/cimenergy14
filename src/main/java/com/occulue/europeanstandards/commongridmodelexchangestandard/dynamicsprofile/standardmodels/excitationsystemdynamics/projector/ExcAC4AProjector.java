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
 * Projector for ExcAC4A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcAC4A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcAC4AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excAC4A")
@Component("excAC4A-projector")
public class ExcAC4AProjector extends ExcAC4AEntityProjector {

  // core constructor
  public ExcAC4AProjector(ExcAC4ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcAC4AEvent
   */
  @EventHandler(payloadType = CreateExcAC4AEvent.class)
  public void handle(CreateExcAC4AEvent event) {
    LOGGER.info("handling CreateExcAC4AEvent - " + event);
    ExcAC4A entity = new ExcAC4A();
    entity.setExcAC4AId(event.getExcAC4AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UpdateExcAC4AEvent
   */
  @EventHandler(payloadType = UpdateExcAC4AEvent.class)
  public void handle(UpdateExcAC4AEvent event) {
    LOGGER.info("handling UpdateExcAC4AEvent - " + event);

    ExcAC4A entity = new ExcAC4A();
    entity.setExcAC4AId(event.getExcAC4AId());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setVimax(event.getVimax());
    entity.setVimin(event.getVimin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event DeleteExcAC4AEvent
   */
  @EventHandler(payloadType = DeleteExcAC4AEvent.class)
  public void handle(DeleteExcAC4AEvent event) {
    LOGGER.info("handling DeleteExcAC4AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcAC4A entity = delete(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignKaToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignKaToExcAC4AEvent.class)
  public void handle(AssignKaToExcAC4AEvent event) {
    LOGGER.info("handling AssignKaToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignKa(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcAC4AEvent.class)
  public void handle(UnAssignKaFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignKa(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignKcToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignKcToExcAC4AEvent.class)
  public void handle(AssignKcToExcAC4AEvent event) {
    LOGGER.info("handling AssignKcToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignKc(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcAC4AEvent.class)
  public void handle(UnAssignKcFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignKc(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignTaToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignTaToExcAC4AEvent.class)
  public void handle(AssignTaToExcAC4AEvent event) {
    LOGGER.info("handling AssignTaToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignTa(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcAC4AEvent.class)
  public void handle(UnAssignTaFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignTa(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignTbToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignTbToExcAC4AEvent.class)
  public void handle(AssignTbToExcAC4AEvent event) {
    LOGGER.info("handling AssignTbToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignTb(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcAC4AEvent.class)
  public void handle(UnAssignTbFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignTb(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignTcToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignTcToExcAC4AEvent.class)
  public void handle(AssignTcToExcAC4AEvent event) {
    LOGGER.info("handling AssignTcToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignTc(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcAC4AEvent.class)
  public void handle(UnAssignTcFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignTc(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignVimaxToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcAC4AEvent.class)
  public void handle(AssignVimaxToExcAC4AEvent event) {
    LOGGER.info("handling AssignVimaxToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignVimax(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcAC4AEvent.class)
  public void handle(UnAssignVimaxFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignVimax(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignViminToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignViminToExcAC4AEvent.class)
  public void handle(AssignViminToExcAC4AEvent event) {
    LOGGER.info("handling AssignViminToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignVimin(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignViminFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcAC4AEvent.class)
  public void handle(UnAssignViminFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignViminFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignVimin(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcAC4AEvent.class)
  public void handle(AssignVrmaxToExcAC4AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignVrmax(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcAC4AEvent.class)
  public void handle(UnAssignVrmaxFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignVrmax(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event AssignVrminToExcAC4AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcAC4AEvent.class)
  public void handle(AssignVrminToExcAC4AEvent event) {
    LOGGER.info("handling AssignVrminToExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcAC4A entity = assignVrmin(event.getExcAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcAC4AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcAC4AEvent.class)
  public void handle(UnAssignVrminFromExcAC4AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcAC4A entity = unAssignVrmin(event.getExcAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcAC4A(entity);
  }

  /**
   * Method to retrieve the ExcAC4A via an ExcAC4APrimaryKey.
   *
   * @param id Long
   * @return ExcAC4A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcAC4A handle(FindExcAC4AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcAC4AId());
  }

  /**
   * Method to retrieve a collection of all ExcAC4As
   *
   * @param query FindAllExcAC4AQuery
   * @return List<ExcAC4A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcAC4A> handle(FindAllExcAC4AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcAC4A, but only if the id matches
   *
   * @param entity ExcAC4A
   */
  protected void emitFindExcAC4A(ExcAC4A entity) {
    LOGGER.info("handling emitFindExcAC4A");

    queryUpdateEmitter.emit(
        FindExcAC4AQuery.class,
        query -> query.getFilter().getExcAC4AId().equals(entity.getExcAC4AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcAC4A
   *
   * @param entity ExcAC4A
   */
  protected void emitFindAllExcAC4A(ExcAC4A entity) {
    LOGGER.info("handling emitFindAllExcAC4A");

    queryUpdateEmitter.emit(FindAllExcAC4AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcAC4AProjector.class.getName());
}
