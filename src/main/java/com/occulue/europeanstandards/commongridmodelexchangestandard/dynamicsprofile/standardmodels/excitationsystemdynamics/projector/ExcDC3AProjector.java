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
 * Projector for ExcDC3A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcDC3A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcDC3AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excDC3A")
@Component("excDC3A-projector")
public class ExcDC3AProjector extends ExcDC3AEntityProjector {

  // core constructor
  public ExcDC3AProjector(ExcDC3ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcDC3AEvent
   */
  @EventHandler(payloadType = CreateExcDC3AEvent.class)
  public void handle(CreateExcDC3AEvent event) {
    LOGGER.info("handling CreateExcDC3AEvent - " + event);
    ExcDC3A entity = new ExcDC3A();
    entity.setExcDC3AId(event.getExcDC3AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UpdateExcDC3AEvent
   */
  @EventHandler(payloadType = UpdateExcDC3AEvent.class)
  public void handle(UpdateExcDC3AEvent event) {
    LOGGER.info("handling UpdateExcDC3AEvent - " + event);

    ExcDC3A entity = new ExcDC3A();
    entity.setExcDC3AId(event.getExcDC3AId());
    entity.setEdfmax(event.getEdfmax());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setEfdlim(event.getEfdlim());
    entity.setEfdmin(event.getEfdmin());
    entity.setExclim(event.getExclim());
    entity.setKe(event.getKe());
    entity.setKr(event.getKr());
    entity.setKs(event.getKs());
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
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event DeleteExcDC3AEvent
   */
  @EventHandler(payloadType = DeleteExcDC3AEvent.class)
  public void handle(DeleteExcDC3AEvent event) {
    LOGGER.info("handling DeleteExcDC3AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcDC3A entity = delete(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignEdfmaxToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignEdfmaxToExcDC3AEvent.class)
  public void handle(AssignEdfmaxToExcDC3AEvent event) {
    LOGGER.info("handling AssignEdfmaxToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignEdfmax(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignEdfmaxFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEdfmaxFromExcDC3AEvent.class)
  public void handle(UnAssignEdfmaxFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignEdfmaxFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignEdfmax(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcDC3AEvent.class)
  public void handle(AssignEfd1ToExcDC3AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignEfd1(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcDC3AEvent.class)
  public void handle(UnAssignEfd1FromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignEfd1(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcDC3AEvent.class)
  public void handle(AssignEfd2ToExcDC3AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignEfd2(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcDC3AEvent.class)
  public void handle(UnAssignEfd2FromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignEfd2(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignEfdlimToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignEfdlimToExcDC3AEvent.class)
  public void handle(AssignEfdlimToExcDC3AEvent event) {
    LOGGER.info("handling AssignEfdlimToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignEfdlim(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignEfdlimFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfdlimFromExcDC3AEvent.class)
  public void handle(UnAssignEfdlimFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignEfdlimFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignEfdlim(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignEfdminToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignEfdminToExcDC3AEvent.class)
  public void handle(AssignEfdminToExcDC3AEvent event) {
    LOGGER.info("handling AssignEfdminToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignEfdmin(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignEfdminFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignEfdminFromExcDC3AEvent.class)
  public void handle(UnAssignEfdminFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignEfdminFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignEfdmin(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignExclimToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignExclimToExcDC3AEvent.class)
  public void handle(AssignExclimToExcDC3AEvent event) {
    LOGGER.info("handling AssignExclimToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignExclim(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignExclimFromExcDC3AEvent.class)
  public void handle(UnAssignExclimFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignExclimFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignExclim(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignKeToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignKeToExcDC3AEvent.class)
  public void handle(AssignKeToExcDC3AEvent event) {
    LOGGER.info("handling AssignKeToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignKe(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcDC3AEvent.class)
  public void handle(UnAssignKeFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignKe(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignKrToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignKrToExcDC3AEvent.class)
  public void handle(AssignKrToExcDC3AEvent event) {
    LOGGER.info("handling AssignKrToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignKr(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignKrFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignKrFromExcDC3AEvent.class)
  public void handle(UnAssignKrFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignKrFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignKr(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignKsToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignKsToExcDC3AEvent.class)
  public void handle(AssignKsToExcDC3AEvent event) {
    LOGGER.info("handling AssignKsToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignKs(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignKsFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcDC3AEvent.class)
  public void handle(UnAssignKsFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignKsFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignKs(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignKvToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignKvToExcDC3AEvent.class)
  public void handle(AssignKvToExcDC3AEvent event) {
    LOGGER.info("handling AssignKvToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignKv(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignKvFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignKvFromExcDC3AEvent.class)
  public void handle(UnAssignKvFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignKvFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignKv(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcDC3AEvent.class)
  public void handle(AssignSeefd1ToExcDC3AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignSeefd1(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcDC3AEvent.class)
  public void handle(UnAssignSeefd1FromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignSeefd1(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcDC3AEvent.class)
  public void handle(AssignSeefd2ToExcDC3AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignSeefd2(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcDC3AEvent.class)
  public void handle(UnAssignSeefd2FromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignSeefd2(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignTeToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignTeToExcDC3AEvent.class)
  public void handle(AssignTeToExcDC3AEvent event) {
    LOGGER.info("handling AssignTeToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignTe(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcDC3AEvent.class)
  public void handle(UnAssignTeFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignTe(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignTrhToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignTrhToExcDC3AEvent.class)
  public void handle(AssignTrhToExcDC3AEvent event) {
    LOGGER.info("handling AssignTrhToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignTrh(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignTrhFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignTrhFromExcDC3AEvent.class)
  public void handle(UnAssignTrhFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignTrhFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignTrh(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcDC3AEvent.class)
  public void handle(AssignVrmaxToExcDC3AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignVrmax(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcDC3AEvent.class)
  public void handle(UnAssignVrmaxFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignVrmax(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event AssignVrminToExcDC3AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcDC3AEvent.class)
  public void handle(AssignVrminToExcDC3AEvent event) {
    LOGGER.info("handling AssignVrminToExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcDC3A entity = assignVrmin(event.getExcDC3AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcDC3AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcDC3AEvent.class)
  public void handle(UnAssignVrminFromExcDC3AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcDC3AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcDC3A entity = unAssignVrmin(event.getExcDC3AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcDC3A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcDC3A(entity);
  }

  /**
   * Method to retrieve the ExcDC3A via an ExcDC3APrimaryKey.
   *
   * @param id Long
   * @return ExcDC3A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcDC3A handle(FindExcDC3AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcDC3AId());
  }

  /**
   * Method to retrieve a collection of all ExcDC3As
   *
   * @param query FindAllExcDC3AQuery
   * @return List<ExcDC3A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcDC3A> handle(FindAllExcDC3AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcDC3A, but only if the id matches
   *
   * @param entity ExcDC3A
   */
  protected void emitFindExcDC3A(ExcDC3A entity) {
    LOGGER.info("handling emitFindExcDC3A");

    queryUpdateEmitter.emit(
        FindExcDC3AQuery.class,
        query -> query.getFilter().getExcDC3AId().equals(entity.getExcDC3AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcDC3A
   *
   * @param entity ExcDC3A
   */
  protected void emitFindAllExcDC3A(ExcDC3A entity) {
    LOGGER.info("handling emitFindAllExcDC3A");

    queryUpdateEmitter.emit(FindAllExcDC3AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcDC3AProjector.class.getName());
}
