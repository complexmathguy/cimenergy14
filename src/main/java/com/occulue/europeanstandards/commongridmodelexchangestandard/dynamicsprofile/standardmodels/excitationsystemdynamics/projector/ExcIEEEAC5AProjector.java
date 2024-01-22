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
 * Projector for ExcIEEEAC5A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEAC5A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEAC5AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEAC5A")
@Component("excIEEEAC5A-projector")
public class ExcIEEEAC5AProjector extends ExcIEEEAC5AEntityProjector {

  // core constructor
  public ExcIEEEAC5AProjector(
      ExcIEEEAC5ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEAC5AEvent.class)
  public void handle(CreateExcIEEEAC5AEvent event) {
    LOGGER.info("handling CreateExcIEEEAC5AEvent - " + event);
    ExcIEEEAC5A entity = new ExcIEEEAC5A();
    entity.setExcIEEEAC5AId(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UpdateExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEAC5AEvent.class)
  public void handle(UpdateExcIEEEAC5AEvent event) {
    LOGGER.info("handling UpdateExcIEEEAC5AEvent - " + event);

    ExcIEEEAC5A entity = new ExcIEEEAC5A();
    entity.setExcIEEEAC5AId(event.getExcIEEEAC5AId());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setKa(event.getKa());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setSeefd1(event.getSeefd1());
    entity.setSeefd2(event.getSeefd2());
    entity.setTa(event.getTa());
    entity.setTe(event.getTe());
    entity.setTf1(event.getTf1());
    entity.setTf2(event.getTf2());
    entity.setTf3(event.getTf3());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event DeleteExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEAC5AEvent.class)
  public void handle(DeleteExcIEEEAC5AEvent event) {
    LOGGER.info("handling DeleteExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEAC5A entity = delete(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcIEEEAC5AEvent.class)
  public void handle(AssignEfd1ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignEfd1(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignEfd1FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignEfd1(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcIEEEAC5AEvent.class)
  public void handle(AssignEfd2ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignEfd2(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignEfd2FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignEfd2(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEAC5AEvent.class)
  public void handle(AssignKaToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignKa(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignKaFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignKa(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEAC5AEvent.class)
  public void handle(AssignKeToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignKe(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignKeFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignKe(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEAC5AEvent.class)
  public void handle(AssignKfToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignKf(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignKfFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignKf(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcIEEEAC5AEvent.class)
  public void handle(AssignSeefd1ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignSeefd1(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignSeefd1FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignSeefd1(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcIEEEAC5AEvent.class)
  public void handle(AssignSeefd2ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignSeefd2(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignSeefd2FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignSeefd2(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEAC5AEvent.class)
  public void handle(AssignTaToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignTa(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignTaFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignTa(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEAC5AEvent.class)
  public void handle(AssignTeToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignTe(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignTeFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignTe(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignTf1ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignTf1ToExcIEEEAC5AEvent.class)
  public void handle(AssignTf1ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignTf1ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignTf1(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignTf1FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTf1FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignTf1FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignTf1FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignTf1(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignTf2ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignTf2ToExcIEEEAC5AEvent.class)
  public void handle(AssignTf2ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignTf2ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignTf2(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignTf2FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTf2FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignTf2FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignTf2FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignTf2(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignTf3ToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignTf3ToExcIEEEAC5AEvent.class)
  public void handle(AssignTf3ToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignTf3ToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignTf3(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignTf3FromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignTf3FromExcIEEEAC5AEvent.class)
  public void handle(UnAssignTf3FromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignTf3FromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignTf3(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEAC5AEvent.class)
  public void handle(AssignVrmaxToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignVrmax(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignVrmax(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEAC5AEvent.class)
  public void handle(AssignVrminToExcIEEEAC5AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEAC5A entity = assignVrmin(event.getExcIEEEAC5AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEAC5AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEAC5AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEAC5AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEAC5AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEAC5A entity = unAssignVrmin(event.getExcIEEEAC5AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEAC5A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEAC5A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEAC5A via an ExcIEEEAC5APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEAC5A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEAC5A handle(FindExcIEEEAC5AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEAC5AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEAC5As
   *
   * @param query FindAllExcIEEEAC5AQuery
   * @return List<ExcIEEEAC5A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEAC5A> handle(FindAllExcIEEEAC5AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEAC5A, but only if the id matches
   *
   * @param entity ExcIEEEAC5A
   */
  protected void emitFindExcIEEEAC5A(ExcIEEEAC5A entity) {
    LOGGER.info("handling emitFindExcIEEEAC5A");

    queryUpdateEmitter.emit(
        FindExcIEEEAC5AQuery.class,
        query -> query.getFilter().getExcIEEEAC5AId().equals(entity.getExcIEEEAC5AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEAC5A
   *
   * @param entity ExcIEEEAC5A
   */
  protected void emitFindAllExcIEEEAC5A(ExcIEEEAC5A entity) {
    LOGGER.info("handling emitFindAllExcIEEEAC5A");

    queryUpdateEmitter.emit(FindAllExcIEEEAC5AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEAC5AProjector.class.getName());
}
