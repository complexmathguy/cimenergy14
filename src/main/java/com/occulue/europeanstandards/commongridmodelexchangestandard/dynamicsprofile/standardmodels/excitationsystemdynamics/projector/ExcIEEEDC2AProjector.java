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
 * Projector for ExcIEEEDC2A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEDC2A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEDC2AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEDC2A")
@Component("excIEEEDC2A-projector")
public class ExcIEEEDC2AProjector extends ExcIEEEDC2AEntityProjector {

  // core constructor
  public ExcIEEEDC2AProjector(
      ExcIEEEDC2ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEDC2AEvent.class)
  public void handle(CreateExcIEEEDC2AEvent event) {
    LOGGER.info("handling CreateExcIEEEDC2AEvent - " + event);
    ExcIEEEDC2A entity = new ExcIEEEDC2A();
    entity.setExcIEEEDC2AId(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UpdateExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEDC2AEvent.class)
  public void handle(UpdateExcIEEEDC2AEvent event) {
    LOGGER.info("handling UpdateExcIEEEDC2AEvent - " + event);

    ExcIEEEDC2A entity = new ExcIEEEDC2A();
    entity.setExcIEEEDC2AId(event.getExcIEEEDC2AId());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setExclim(event.getExclim());
    entity.setKa(event.getKa());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setSeefd1(event.getSeefd1());
    entity.setSeefd2(event.getSeefd2());
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
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event DeleteExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEDC2AEvent.class)
  public void handle(DeleteExcIEEEDC2AEvent event) {
    LOGGER.info("handling DeleteExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEDC2A entity = delete(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcIEEEDC2AEvent.class)
  public void handle(AssignEfd1ToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignEfd1(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcIEEEDC2AEvent.class)
  public void handle(UnAssignEfd1FromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignEfd1(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcIEEEDC2AEvent.class)
  public void handle(AssignEfd2ToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignEfd2(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcIEEEDC2AEvent.class)
  public void handle(UnAssignEfd2FromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignEfd2(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignExclimToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignExclimToExcIEEEDC2AEvent.class)
  public void handle(AssignExclimToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignExclimToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignExclim(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignExclimFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignExclimFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignExclimFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignExclim(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEDC2AEvent.class)
  public void handle(AssignKaToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignKa(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignKaFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignKa(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEDC2AEvent.class)
  public void handle(AssignKeToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignKe(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignKeFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignKe(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEDC2AEvent.class)
  public void handle(AssignKfToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignKf(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignKfFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignKf(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcIEEEDC2AEvent.class)
  public void handle(AssignSeefd1ToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignSeefd1(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcIEEEDC2AEvent.class)
  public void handle(UnAssignSeefd1FromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignSeefd1(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcIEEEDC2AEvent.class)
  public void handle(AssignSeefd2ToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignSeefd2(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcIEEEDC2AEvent.class)
  public void handle(UnAssignSeefd2FromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignSeefd2(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEDC2AEvent.class)
  public void handle(AssignTaToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignTa(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignTaFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignTa(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEDC2AEvent.class)
  public void handle(AssignTbToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignTb(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignTbFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignTb(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEDC2AEvent.class)
  public void handle(AssignTcToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignTc(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignTcFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignTc(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEDC2AEvent.class)
  public void handle(AssignTeToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignTe(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignTeFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignTe(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEDC2AEvent.class)
  public void handle(AssignTfToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignTf(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignTfFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignTf(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignUelinToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignUelinToExcIEEEDC2AEvent.class)
  public void handle(AssignUelinToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignUelinToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignUelin(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignUelinFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignUelinFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignUelinFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignUelinFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignUelin(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEDC2AEvent.class)
  public void handle(AssignVrmaxToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignVrmax(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignVrmax(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEDC2AEvent.class)
  public void handle(AssignVrminToExcIEEEDC2AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC2A entity = assignVrmin(event.getExcIEEEDC2AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEDC2AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEDC2AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEDC2AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEDC2AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC2A entity = unAssignVrmin(event.getExcIEEEDC2AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC2A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC2A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEDC2A via an ExcIEEEDC2APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEDC2A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEDC2A handle(FindExcIEEEDC2AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEDC2AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC2As
   *
   * @param query FindAllExcIEEEDC2AQuery
   * @return List<ExcIEEEDC2A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEDC2A> handle(FindAllExcIEEEDC2AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEDC2A, but only if the id matches
   *
   * @param entity ExcIEEEDC2A
   */
  protected void emitFindExcIEEEDC2A(ExcIEEEDC2A entity) {
    LOGGER.info("handling emitFindExcIEEEDC2A");

    queryUpdateEmitter.emit(
        FindExcIEEEDC2AQuery.class,
        query -> query.getFilter().getExcIEEEDC2AId().equals(entity.getExcIEEEDC2AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEDC2A
   *
   * @param entity ExcIEEEDC2A
   */
  protected void emitFindAllExcIEEEDC2A(ExcIEEEDC2A entity) {
    LOGGER.info("handling emitFindAllExcIEEEDC2A");

    queryUpdateEmitter.emit(FindAllExcIEEEDC2AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC2AProjector.class.getName());
}
