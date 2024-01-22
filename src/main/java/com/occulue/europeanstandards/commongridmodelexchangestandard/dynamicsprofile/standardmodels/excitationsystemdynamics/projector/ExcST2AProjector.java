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
 * Projector for ExcST2A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcST2A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcST2AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excST2A")
@Component("excST2A-projector")
public class ExcST2AProjector extends ExcST2AEntityProjector {

  // core constructor
  public ExcST2AProjector(ExcST2ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcST2AEvent
   */
  @EventHandler(payloadType = CreateExcST2AEvent.class)
  public void handle(CreateExcST2AEvent event) {
    LOGGER.info("handling CreateExcST2AEvent - " + event);
    ExcST2A entity = new ExcST2A();
    entity.setExcST2AId(event.getExcST2AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UpdateExcST2AEvent
   */
  @EventHandler(payloadType = UpdateExcST2AEvent.class)
  public void handle(UpdateExcST2AEvent event) {
    LOGGER.info("handling UpdateExcST2AEvent - " + event);

    ExcST2A entity = new ExcST2A();
    entity.setExcST2AId(event.getExcST2AId());
    entity.setEfdmax(event.getEfdmax());
    entity.setKa(event.getKa());
    entity.setKc(event.getKc());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setTa(event.getTa());
    entity.setTb(event.getTb());
    entity.setTc(event.getTc());
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
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event DeleteExcST2AEvent
   */
  @EventHandler(payloadType = DeleteExcST2AEvent.class)
  public void handle(DeleteExcST2AEvent event) {
    LOGGER.info("handling DeleteExcST2AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcST2A entity = delete(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignEfdmaxToExcST2AEvent
   */
  @EventHandler(payloadType = AssignEfdmaxToExcST2AEvent.class)
  public void handle(AssignEfdmaxToExcST2AEvent event) {
    LOGGER.info("handling AssignEfdmaxToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignEfdmax(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignEfdmaxFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignEfdmaxFromExcST2AEvent.class)
  public void handle(UnAssignEfdmaxFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignEfdmaxFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignEfdmax(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignKaToExcST2AEvent
   */
  @EventHandler(payloadType = AssignKaToExcST2AEvent.class)
  public void handle(AssignKaToExcST2AEvent event) {
    LOGGER.info("handling AssignKaToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignKa(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcST2AEvent.class)
  public void handle(UnAssignKaFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignKa(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignKcToExcST2AEvent
   */
  @EventHandler(payloadType = AssignKcToExcST2AEvent.class)
  public void handle(AssignKcToExcST2AEvent event) {
    LOGGER.info("handling AssignKcToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignKc(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignKcFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcST2AEvent.class)
  public void handle(UnAssignKcFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignKcFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignKc(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignKeToExcST2AEvent
   */
  @EventHandler(payloadType = AssignKeToExcST2AEvent.class)
  public void handle(AssignKeToExcST2AEvent event) {
    LOGGER.info("handling AssignKeToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignKe(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcST2AEvent.class)
  public void handle(UnAssignKeFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignKe(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignKfToExcST2AEvent
   */
  @EventHandler(payloadType = AssignKfToExcST2AEvent.class)
  public void handle(AssignKfToExcST2AEvent event) {
    LOGGER.info("handling AssignKfToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignKf(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcST2AEvent.class)
  public void handle(UnAssignKfFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignKf(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignKiToExcST2AEvent
   */
  @EventHandler(payloadType = AssignKiToExcST2AEvent.class)
  public void handle(AssignKiToExcST2AEvent event) {
    LOGGER.info("handling AssignKiToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignKi(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignKiFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcST2AEvent.class)
  public void handle(UnAssignKiFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignKiFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignKi(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignKpToExcST2AEvent
   */
  @EventHandler(payloadType = AssignKpToExcST2AEvent.class)
  public void handle(AssignKpToExcST2AEvent event) {
    LOGGER.info("handling AssignKpToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignKp(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignKpFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcST2AEvent.class)
  public void handle(UnAssignKpFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignKpFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignKp(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignTaToExcST2AEvent
   */
  @EventHandler(payloadType = AssignTaToExcST2AEvent.class)
  public void handle(AssignTaToExcST2AEvent event) {
    LOGGER.info("handling AssignTaToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignTa(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcST2AEvent.class)
  public void handle(UnAssignTaFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignTa(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignTbToExcST2AEvent
   */
  @EventHandler(payloadType = AssignTbToExcST2AEvent.class)
  public void handle(AssignTbToExcST2AEvent event) {
    LOGGER.info("handling AssignTbToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignTb(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcST2AEvent.class)
  public void handle(UnAssignTbFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignTb(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignTcToExcST2AEvent
   */
  @EventHandler(payloadType = AssignTcToExcST2AEvent.class)
  public void handle(AssignTcToExcST2AEvent event) {
    LOGGER.info("handling AssignTcToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignTc(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcST2AEvent.class)
  public void handle(UnAssignTcFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignTc(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignTeToExcST2AEvent
   */
  @EventHandler(payloadType = AssignTeToExcST2AEvent.class)
  public void handle(AssignTeToExcST2AEvent event) {
    LOGGER.info("handling AssignTeToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignTe(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcST2AEvent.class)
  public void handle(UnAssignTeFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignTe(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignTfToExcST2AEvent
   */
  @EventHandler(payloadType = AssignTfToExcST2AEvent.class)
  public void handle(AssignTfToExcST2AEvent event) {
    LOGGER.info("handling AssignTfToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignTf(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcST2AEvent.class)
  public void handle(UnAssignTfFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignTf(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignUelinToExcST2AEvent
   */
  @EventHandler(payloadType = AssignUelinToExcST2AEvent.class)
  public void handle(AssignUelinToExcST2AEvent event) {
    LOGGER.info("handling AssignUelinToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignUelin(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignUelinFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignUelinFromExcST2AEvent.class)
  public void handle(UnAssignUelinFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignUelinFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignUelin(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcST2AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcST2AEvent.class)
  public void handle(AssignVrmaxToExcST2AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignVrmax(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcST2AEvent.class)
  public void handle(UnAssignVrmaxFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignVrmax(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event AssignVrminToExcST2AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcST2AEvent.class)
  public void handle(AssignVrminToExcST2AEvent event) {
    LOGGER.info("handling AssignVrminToExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcST2A entity = assignVrmin(event.getExcST2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcST2AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcST2AEvent.class)
  public void handle(UnAssignVrminFromExcST2AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcST2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcST2A entity = unAssignVrmin(event.getExcST2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcST2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcST2A(entity);
  }

  /**
   * Method to retrieve the ExcST2A via an ExcST2APrimaryKey.
   *
   * @param id Long
   * @return ExcST2A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcST2A handle(FindExcST2AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcST2AId());
  }

  /**
   * Method to retrieve a collection of all ExcST2As
   *
   * @param query FindAllExcST2AQuery
   * @return List<ExcST2A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcST2A> handle(FindAllExcST2AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcST2A, but only if the id matches
   *
   * @param entity ExcST2A
   */
  protected void emitFindExcST2A(ExcST2A entity) {
    LOGGER.info("handling emitFindExcST2A");

    queryUpdateEmitter.emit(
        FindExcST2AQuery.class,
        query -> query.getFilter().getExcST2AId().equals(entity.getExcST2AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcST2A
   *
   * @param entity ExcST2A
   */
  protected void emitFindAllExcST2A(ExcST2A entity) {
    LOGGER.info("handling emitFindAllExcST2A");

    queryUpdateEmitter.emit(FindAllExcST2AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcST2AProjector.class.getName());
}
