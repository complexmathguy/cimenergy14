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
 * Projector for ExcIEEEDC3A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEDC3A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEDC3AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEDC3A")
@Component("excIEEEDC3A-projector")
public class ExcIEEEDC3AProjector extends ExcIEEEDC3AEntityProjector {

  // core constructor
  public ExcIEEEDC3AProjector(
      ExcIEEEDC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEDC3AEvent.class)
  public void handle(CreateExcIEEEDC3AEvent event) {
    LOGGER.info("handling CreateExcIEEEDC3AEvent - " + event);
    ExcIEEEDC3A entity = new ExcIEEEDC3A();
    entity.setExcIEEEDC3AId(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UpdateExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEDC3AEvent.class)
  public void handle(UpdateExcIEEEDC3AEvent event) {
    LOGGER.info("handling UpdateExcIEEEDC3AEvent - " + event);

    ExcIEEEDC3A entity = new ExcIEEEDC3A();
    entity.setExcIEEEDC3AId(event.getExcIEEEDC3AId());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setExclim(event.getExclim());
    entity.setKe(event.getKe());
    entity.setKv(event.getKv());
    entity.setSeefd1(event.getSeefd1());
    entity.setSeefd2(event.getSeefd2());
    entity.setTe(event.getTe());
    entity.setTrh(event.getTrh());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event DeleteExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEDC3AEvent.class)
  public void handle(DeleteExcIEEEDC3AEvent event) {
    LOGGER.info("handling DeleteExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEDC3A entity = delete(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcIEEEDC3AEvent.class)
  public void handle(AssignEfd1ToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignEfd1(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcIEEEDC3AEvent.class)
  public void handle(UnAssignEfd1FromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignEfd1(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcIEEEDC3AEvent.class)
  public void handle(AssignEfd2ToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignEfd2(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcIEEEDC3AEvent.class)
  public void handle(UnAssignEfd2FromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignEfd2(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignExclimToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignExclimToExcIEEEDC3AEvent.class)
  public void handle(AssignExclimToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignExclimToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignExclim(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignExclimFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignExclimFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignExclimFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignExclim(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEDC3AEvent.class)
  public void handle(AssignKeToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignKe(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignKeFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignKe(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignKvToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignKvToExcIEEEDC3AEvent.class)
  public void handle(AssignKvToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignKvToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignKv(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignKvFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignKvFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignKvFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignKvFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignKv(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcIEEEDC3AEvent.class)
  public void handle(AssignSeefd1ToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignSeefd1(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcIEEEDC3AEvent.class)
  public void handle(UnAssignSeefd1FromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignSeefd1(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcIEEEDC3AEvent.class)
  public void handle(AssignSeefd2ToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignSeefd2(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcIEEEDC3AEvent.class)
  public void handle(UnAssignSeefd2FromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignSeefd2(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEDC3AEvent.class)
  public void handle(AssignTeToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignTe(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignTeFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignTe(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignTrhToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignTrhToExcIEEEDC3AEvent.class)
  public void handle(AssignTrhToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignTrhToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignTrh(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignTrhFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignTrhFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignTrhFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignTrhFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignTrh(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEDC3AEvent.class)
  public void handle(AssignVrmaxToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignVrmax(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignVrmax(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEDC3AEvent.class)
  public void handle(AssignVrminToExcIEEEDC3AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC3A entity = assignVrmin(event.getExcIEEEDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEDC3AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEDC3AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEDC3AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC3A entity = unAssignVrmin(event.getExcIEEEDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC3A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEDC3A via an ExcIEEEDC3APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEDC3A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEDC3A handle(FindExcIEEEDC3AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEDC3AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC3As
   *
   * @param query FindAllExcIEEEDC3AQuery
   * @return List<ExcIEEEDC3A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEDC3A> handle(FindAllExcIEEEDC3AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEDC3A, but only if the id matches
   *
   * @param entity ExcIEEEDC3A
   */
  protected void emitFindExcIEEEDC3A(ExcIEEEDC3A entity) {
    LOGGER.info("handling emitFindExcIEEEDC3A");

    queryUpdateEmitter.emit(
        FindExcIEEEDC3AQuery.class,
        query -> query.getFilter().getExcIEEEDC3AId().equals(entity.getExcIEEEDC3AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEDC3A
   *
   * @param entity ExcIEEEDC3A
   */
  protected void emitFindAllExcIEEEDC3A(ExcIEEEDC3A entity) {
    LOGGER.info("handling emitFindAllExcIEEEDC3A");

    queryUpdateEmitter.emit(FindAllExcIEEEDC3AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC3AProjector.class.getName());
}
