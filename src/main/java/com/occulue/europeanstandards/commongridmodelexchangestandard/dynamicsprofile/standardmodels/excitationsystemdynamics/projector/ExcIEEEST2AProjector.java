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
 * Projector for ExcIEEEST2A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEST2A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEST2AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEST2A")
@Component("excIEEEST2A-projector")
public class ExcIEEEST2AProjector extends ExcIEEEST2AEntityProjector {

  // core constructor
  public ExcIEEEST2AProjector(
      ExcIEEEST2ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEST2AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEST2AEvent.class)
  public void handle(CreateExcIEEEST2AEvent event) {
    LOGGER.info("handling CreateExcIEEEST2AEvent - " + event);
    ExcIEEEST2A entity = new ExcIEEEST2A();
    entity.setExcIEEEST2AId(event.getExcIEEEST2AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UpdateExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEST2AEvent.class)
  public void handle(UpdateExcIEEEST2AEvent event) {
    LOGGER.info("handling UpdateExcIEEEST2AEvent - " + event);

    ExcIEEEST2A entity = new ExcIEEEST2A();
    entity.setExcIEEEST2AId(event.getExcIEEEST2AId());
    entity.setEfdmax(event.getEfdmax());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setTa(event.getTa());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setUelin(event.getUelin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event DeleteExcIEEEST2AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEST2AEvent.class)
  public void handle(DeleteExcIEEEST2AEvent event) {
    LOGGER.info("handling DeleteExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEST2A entity = delete(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcIEEEST2AEvent.class)
  public void handle(AssignEfdmaxToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignEfdmax(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcIEEEST2AEvent.class)
  public void handle(UnAssignEfdmaxFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignEfdmax(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEST2AEvent.class)
  public void handle(AssignKaToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignKa(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEST2AEvent.class)
  public void handle(UnAssignKaFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignKa(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignKcToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignKcToExcIEEEST2AEvent.class)
  public void handle(AssignKcToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignKcToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignKc(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcIEEEST2AEvent.class)
  public void handle(UnAssignKcFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignKc(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEST2AEvent.class)
  public void handle(AssignKeToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignKe(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEST2AEvent.class)
  public void handle(UnAssignKeFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignKe(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEST2AEvent.class)
  public void handle(AssignKfToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignKf(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEST2AEvent.class)
  public void handle(UnAssignKfFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignKf(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignKiToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignKiToExcIEEEST2AEvent.class)
  public void handle(AssignKiToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignKiToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignKi(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignKiFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcIEEEST2AEvent.class)
  public void handle(UnAssignKiFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignKiFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignKi(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignKpToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignKpToExcIEEEST2AEvent.class)
  public void handle(AssignKpToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignKpToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignKp(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignKpFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcIEEEST2AEvent.class)
  public void handle(UnAssignKpFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignKpFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignKp(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEST2AEvent.class)
  public void handle(AssignTaToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignTa(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEST2AEvent.class)
  public void handle(UnAssignTaFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignTa(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEST2AEvent.class)
  public void handle(AssignTeToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignTe(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEST2AEvent.class)
  public void handle(UnAssignTeFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignTe(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEST2AEvent.class)
  public void handle(AssignTfToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignTf(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEST2AEvent.class)
  public void handle(UnAssignTfFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignTf(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignUelinToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignUelinToExcIEEEST2AEvent.class)
  public void handle(AssignUelinToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignUelinToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignUelin(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignUelinFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignUelinFromExcIEEEST2AEvent.class)
  public void handle(UnAssignUelinFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignUelinFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignUelin(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEST2AEvent.class)
  public void handle(AssignVrmaxToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignVrmax(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEST2AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignVrmax(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEST2AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEST2AEvent.class)
  public void handle(AssignVrminToExcIEEEST2AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEST2A entity = assignVrmin(event.getExcIEEEST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEST2AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEST2AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEST2AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEST2A entity = unAssignVrmin(event.getExcIEEEST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEST2A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEST2A via an ExcIEEEST2APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEST2A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEST2A handle(FindExcIEEEST2AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEST2AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEST2As
   *
   * @param query FindAllExcIEEEST2AQuery
   * @return List<ExcIEEEST2A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEST2A> handle(FindAllExcIEEEST2AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEST2A, but only if the id matches
   *
   * @param entity ExcIEEEST2A
   */
  protected void emitFindExcIEEEST2A(ExcIEEEST2A entity) {
    LOGGER.info("handling emitFindExcIEEEST2A");

    queryUpdateEmitter.emit(
        FindExcIEEEST2AQuery.class,
        query -> query.getFilter().getExcIEEEST2AId().equals(entity.getExcIEEEST2AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEST2A
   *
   * @param entity ExcIEEEST2A
   */
  protected void emitFindAllExcIEEEST2A(ExcIEEEST2A entity) {
    LOGGER.info("handling emitFindAllExcIEEEST2A");

    queryUpdateEmitter.emit(FindAllExcIEEEST2AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEST2AProjector.class.getName());
}
