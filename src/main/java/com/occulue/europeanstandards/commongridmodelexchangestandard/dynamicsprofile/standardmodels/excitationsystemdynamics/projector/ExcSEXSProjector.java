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
 * Projector for ExcSEXS as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcSEXS are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcSEXSAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excSEXS")
@Component("excSEXS-projector")
public class ExcSEXSProjector extends ExcSEXSEntityProjector {

  // core constructor
  public ExcSEXSProjector(ExcSEXSRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcSEXSEvent
   */
  @EventHandler(payloadType = CreateExcSEXSEvent.class)
  public void handle(CreateExcSEXSEvent event) {
    LOGGER.info("handling CreateExcSEXSEvent - " + event);
    ExcSEXS entity = new ExcSEXS();
    entity.setExcSEXSId(event.getExcSEXSId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UpdateExcSEXSEvent
   */
  @EventHandler(payloadType = UpdateExcSEXSEvent.class)
  public void handle(UpdateExcSEXSEvent event) {
    LOGGER.info("handling UpdateExcSEXSEvent - " + event);

    ExcSEXS entity = new ExcSEXS();
    entity.setExcSEXSId(event.getExcSEXSId());
    entity.setEfdmax(event.getEfdmax());
    entity.setEfdmin(event.getEfdmin());
    entity.setEmax(event.getEmax());
    entity.setEmin(event.getEmin());
    entity.setK(event.getK());
    entity.setKc(event.getKc());
    entity.setTatb(event.getTatb());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
    entity.setTe(event.getTe());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event DeleteExcSEXSEvent
   */
  @EventHandler(payloadType = DeleteExcSEXSEvent.class)
  public void handle(DeleteExcSEXSEvent event) {
    LOGGER.info("handling DeleteExcSEXSEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcSEXS entity = delete(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcSEXSEvent.class)
  public void handle(AssignEfdmaxToExcSEXSEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignEfdmax(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcSEXSEvent.class)
  public void handle(UnAssignEfdmaxFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignEfdmax(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignEfdminToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcSEXSEvent.class)
  public void handle(AssignEfdminToExcSEXSEvent event) {
    LOGGER.info("handling AssignEfdminToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignEfdmin(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcSEXSEvent.class)
  public void handle(UnAssignEfdminFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignEfdmin(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignEmaxToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignEmaxToExcSEXSEvent.class)
  public void handle(AssignEmaxToExcSEXSEvent event) {
    LOGGER.info("handling AssignEmaxToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignEmax(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignEmaxFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignEmaxFromExcSEXSEvent.class)
  public void handle(UnAssignEmaxFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignEmaxFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignEmax(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignEminToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignEminToExcSEXSEvent.class)
  public void handle(AssignEminToExcSEXSEvent event) {
    LOGGER.info("handling AssignEminToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignEmin(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignEminFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignEminFromExcSEXSEvent.class)
  public void handle(UnAssignEminFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignEminFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignEmin(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignKToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignKToExcSEXSEvent.class)
  public void handle(AssignKToExcSEXSEvent event) {
    LOGGER.info("handling AssignKToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignK(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignKFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignKFromExcSEXSEvent.class)
  public void handle(UnAssignKFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignKFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignK(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignKcToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignKcToExcSEXSEvent.class)
  public void handle(AssignKcToExcSEXSEvent event) {
    LOGGER.info("handling AssignKcToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignKc(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignKcFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcSEXSEvent.class)
  public void handle(UnAssignKcFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignKcFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignKc(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignTatbToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignTatbToExcSEXSEvent.class)
  public void handle(AssignTatbToExcSEXSEvent event) {
    LOGGER.info("handling AssignTatbToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignTatb(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignTatbFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignTatbFromExcSEXSEvent.class)
  public void handle(UnAssignTatbFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignTatbFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignTatb(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignTbToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignTbToExcSEXSEvent.class)
  public void handle(AssignTbToExcSEXSEvent event) {
    LOGGER.info("handling AssignTbToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignTb(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignTbFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcSEXSEvent.class)
  public void handle(UnAssignTbFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignTbFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignTb(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignTcToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignTcToExcSEXSEvent.class)
  public void handle(AssignTcToExcSEXSEvent event) {
    LOGGER.info("handling AssignTcToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignTc(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignTcFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcSEXSEvent.class)
  public void handle(UnAssignTcFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignTcFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignTc(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event AssignTeToExcSEXSEvent
   */
  @EventHandler(payloadType = AssignTeToExcSEXSEvent.class)
  public void handle(AssignTeToExcSEXSEvent event) {
    LOGGER.info("handling AssignTeToExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcSEXS entity = assignTe(event.getExcSEXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /*
   * @param	event UnAssignTeFromExcSEXSEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcSEXSEvent.class)
  public void handle(UnAssignTeFromExcSEXSEvent event) {
    LOGGER.info("handling UnAssignTeFromExcSEXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcSEXS entity = unAssignTe(event.getExcSEXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcSEXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcSEXS(entity);
  }

  /**
   * Method to retrieve the ExcSEXS via an ExcSEXSPrimaryKey.
   *
   * @param id Long
   * @return ExcSEXS
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcSEXS handle(FindExcSEXSQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcSEXSId());
  }

  /**
   * Method to retrieve a collection of all ExcSEXSs
   *
   * @param query FindAllExcSEXSQuery
   * @return List<ExcSEXS>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcSEXS> handle(FindAllExcSEXSQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcSEXS, but only if the id matches
   *
   * @param entity ExcSEXS
   */
  protected void emitFindExcSEXS(ExcSEXS entity) {
    LOGGER.info("handling emitFindExcSEXS");

    queryUpdateEmitter.emit(
        FindExcSEXSQuery.class,
        query -> query.getFilter().getExcSEXSId().equals(entity.getExcSEXSId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcSEXS
   *
   * @param entity ExcSEXS
   */
  protected void emitFindAllExcSEXS(ExcSEXS entity) {
    LOGGER.info("handling emitFindAllExcSEXS");

    queryUpdateEmitter.emit(FindAllExcSEXSQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcSEXSProjector.class.getName());
}
