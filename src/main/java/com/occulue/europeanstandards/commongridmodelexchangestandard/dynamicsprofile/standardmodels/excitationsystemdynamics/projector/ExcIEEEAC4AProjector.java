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
 * Projector for ExcIEEEAC4A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC4A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC4AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC4A")
@Component("excIEEEAC4A-projector")
public class ExcIEEEAC4AProjector extends ExcIEEEAC4AEntityProjector {

  // core constructor
  public ExcIEEEAC4AProjector(
      ExcIEEEAC4ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC4AEvent.class)
  public void handle(CreateExcIEEEAC4AEvent event) {
    LOGGER.info("handling CreateExcIEEEAC4AEvent - " + event);
    ExcIEEEAC4A entity = new ExcIEEEAC4A();
    entity.setExcIEEEAC4AId(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC4AEvent.class)
  public void handle(UpdateExcIEEEAC4AEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC4AEvent - " + event);

    ExcIEEEAC4A entity = new ExcIEEEAC4A();
    entity.setExcIEEEAC4AId(event.getExcIEEEAC4AId());
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
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC4AEvent.class)
  public void handle(DeleteExcIEEEAC4AEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC4A entity = delete(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC4AEvent.class)
  public void handle(AssignKaToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignKa(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignKa(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEAC4AEvent.class)
  public void handle(AssignKcToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignKc(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignKcFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignKc(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC4AEvent.class)
  public void handle(AssignTaToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignTa(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignTa(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEAC4AEvent.class)
  public void handle(AssignTbToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignTb(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignTbFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignTb(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEAC4AEvent.class)
  public void handle(AssignTcToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignTc(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignTcFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignTc(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignVimaxToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcIEEEAC4AEvent.class)
  public void handle(AssignVimaxToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignVimaxToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignVimax(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignVimaxFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignVimax(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignViminToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignViminToExcIEEEAC4AEvent.class)
  public void handle(AssignViminToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignViminToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignVimin(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignViminFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignViminFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignViminFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignViminFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignVimin(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC4AEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignVrmax(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignVrmax(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC4AEvent.class)
  public void handle(AssignVrminToExcIEEEAC4AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC4A entity = assignVrmin(event.getExcIEEEAC4AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC4AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC4AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC4AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC4AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC4A entity = unAssignVrmin(event.getExcIEEEAC4AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC4A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC4A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC4A via an ExcIEEEAC4APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC4A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC4A handle(FindExcIEEEAC4AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC4AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC4As
   *
   * @param query FindAllExcIEEEAC4AQuery
   * @return List<ExcIEEEAC4A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC4A> handle(FindAllExcIEEEAC4AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC4A, but only if the id matches
   *
   * @param entity ExcIEEEAC4A
   */
  protected void emitFindExcIEEEAC4A(ExcIEEEAC4A entity) {
    LOGGER.info("handling emitFindExcIEEEAC4A");

    queryUpdateEmitter.emit(
        FindExcIEEEAC4AQuery.class,
        query -> query.getFilter().getExcIEEEAC4AId().equals(entity.getExcIEEEAC4AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC4A
   *
   * @param entity ExcIEEEAC4A
   */
  protected void emitFindAllExcIEEEAC4A(ExcIEEEAC4A entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC4A");

    queryUpdateEmitter.emit(FindAllExcIEEEAC4AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC4AProjector.class.getName());
}
