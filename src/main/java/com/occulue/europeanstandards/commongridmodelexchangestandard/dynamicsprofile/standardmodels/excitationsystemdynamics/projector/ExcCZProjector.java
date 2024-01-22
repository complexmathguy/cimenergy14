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
 * Projector for ExcCZ as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcCZ are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcCZAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excCZ")
@Component("excCZ-projector")
public class ExcCZProjector extends ExcCZEntityProjector {

  // core constructor
  public ExcCZProjector(ExcCZRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcCZEvent
   */
  @EventHandler(payloadType = CreateExcCZEvent.class)
  public void handle(CreateExcCZEvent event) {
    LOGGER.info("handling CreateExcCZEvent - " + event);
    ExcCZ entity = new ExcCZ();
    entity.setExcCZId(event.getExcCZId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UpdateExcCZEvent
   */
  @EventHandler(payloadType = UpdateExcCZEvent.class)
  public void handle(UpdateExcCZEvent event) {
    LOGGER.info("handling UpdateExcCZEvent - " + event);

    ExcCZ entity = new ExcCZ();
    entity.setExcCZId(event.getExcCZId());
    entity.setEfdmax(event.getEfdmax());
    entity.setEfdmin(event.getEfdmin());
    entity.setKa(event.getKa());
    entity.setKe(event.getKe());
    entity.setKp(event.getKp());
    entity.setTa(event.getTa());
    entity.setTc(event.getTc());
    entity.setTe(event.getTe());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event DeleteExcCZEvent
   */
  @EventHandler(payloadType = DeleteExcCZEvent.class)
  public void handle(DeleteExcCZEvent event) {
    LOGGER.info("handling DeleteExcCZEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcCZ entity = delete(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcCZEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcCZEvent.class)
  public void handle(AssignEfdmaxToExcCZEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignEfdmax(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcCZEvent.class)
  public void handle(UnAssignEfdmaxFromExcCZEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignEfdmax(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignEfdminToExcCZEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcCZEvent.class)
  public void handle(AssignEfdminToExcCZEvent event) {
    LOGGER.info("handling AssignEfdminToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignEfdmin(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcCZEvent.class)
  public void handle(UnAssignEfdminFromExcCZEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignEfdmin(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignKaToExcCZEvent
   */
  @EventHandler(payloadType = AssignKaToExcCZEvent.class)
  public void handle(AssignKaToExcCZEvent event) {
    LOGGER.info("handling AssignKaToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignKa(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignKaFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcCZEvent.class)
  public void handle(UnAssignKaFromExcCZEvent event) {
    LOGGER.info("handling UnAssignKaFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignKa(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignKeToExcCZEvent
   */
  @EventHandler(payloadType = AssignKeToExcCZEvent.class)
  public void handle(AssignKeToExcCZEvent event) {
    LOGGER.info("handling AssignKeToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignKe(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignKeFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcCZEvent.class)
  public void handle(UnAssignKeFromExcCZEvent event) {
    LOGGER.info("handling UnAssignKeFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignKe(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignKpToExcCZEvent
   */
  @EventHandler(payloadType = AssignKpToExcCZEvent.class)
  public void handle(AssignKpToExcCZEvent event) {
    LOGGER.info("handling AssignKpToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignKp(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignKpFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcCZEvent.class)
  public void handle(UnAssignKpFromExcCZEvent event) {
    LOGGER.info("handling UnAssignKpFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignKp(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignTaToExcCZEvent
   */
  @EventHandler(payloadType = AssignTaToExcCZEvent.class)
  public void handle(AssignTaToExcCZEvent event) {
    LOGGER.info("handling AssignTaToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignTa(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignTaFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcCZEvent.class)
  public void handle(UnAssignTaFromExcCZEvent event) {
    LOGGER.info("handling UnAssignTaFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignTa(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignTcToExcCZEvent
   */
  @EventHandler(payloadType = AssignTcToExcCZEvent.class)
  public void handle(AssignTcToExcCZEvent event) {
    LOGGER.info("handling AssignTcToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignTc(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignTcFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcCZEvent.class)
  public void handle(UnAssignTcFromExcCZEvent event) {
    LOGGER.info("handling UnAssignTcFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignTc(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignTeToExcCZEvent
   */
  @EventHandler(payloadType = AssignTeToExcCZEvent.class)
  public void handle(AssignTeToExcCZEvent event) {
    LOGGER.info("handling AssignTeToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignTe(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignTeFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcCZEvent.class)
  public void handle(UnAssignTeFromExcCZEvent event) {
    LOGGER.info("handling UnAssignTeFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignTe(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignVrmaxToExcCZEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcCZEvent.class)
  public void handle(AssignVrmaxToExcCZEvent event) {
    LOGGER.info("handling AssignVrmaxToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignVrmax(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcCZEvent.class)
  public void handle(UnAssignVrmaxFromExcCZEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignVrmax(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event AssignVrminToExcCZEvent
   */
  @EventHandler(payloadType = AssignVrminToExcCZEvent.class)
  public void handle(AssignVrminToExcCZEvent event) {
    LOGGER.info("handling AssignVrminToExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcCZ entity = assignVrmin(event.getExcCZId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcCZEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcCZEvent.class)
  public void handle(UnAssignVrminFromExcCZEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcCZEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcCZ entity = unAssignVrmin(event.getExcCZId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcCZ(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcCZ(entity);
  }

  /**
   * Method to retrieve the ExcCZ via an ExcCZPrimaryKey.
   *
   * @param id Long
   * @return ExcCZ
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcCZ handle(FindExcCZQuery query) throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcCZId());
  }

  /**
   * Method to retrieve a collection of all ExcCZs
   *
   * @param query FindAllExcCZQuery
   * @return List<ExcCZ>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcCZ> handle(FindAllExcCZQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcCZ, but only if the id matches
   *
   * @param entity ExcCZ
   */
  protected void emitFindExcCZ(ExcCZ entity) {
    LOGGER.info("handling emitFindExcCZ");

    queryUpdateEmitter.emit(
        FindExcCZQuery.class,
        query -> query.getFilter().getExcCZId().equals(entity.getExcCZId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcCZ
   *
   * @param entity ExcCZ
   */
  protected void emitFindAllExcCZ(ExcCZ entity) {
    LOGGER.info("handling emitFindAllExcCZ");

    queryUpdateEmitter.emit(FindAllExcCZQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcCZProjector.class.getName());
}
