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
 * Projector for ExcIEEEDC1A as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEDC1A are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEDC1AAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEDC1A")
@Component("excIEEEDC1A-projector")
public class ExcIEEEDC1AProjector extends ExcIEEEDC1AEntityProjector {

  // core constructor
  public ExcIEEEDC1AProjector(
      ExcIEEEDC1ARepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = CreateExcIEEEDC1AEvent.class)
  public void handle(CreateExcIEEEDC1AEvent event) {
    LOGGER.info("handling CreateExcIEEEDC1AEvent - " + event);
    ExcIEEEDC1A entity = new ExcIEEEDC1A();
    entity.setExcIEEEDC1AId(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UpdateExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEDC1AEvent.class)
  public void handle(UpdateExcIEEEDC1AEvent event) {
    LOGGER.info("handling UpdateExcIEEEDC1AEvent - " + event);

    ExcIEEEDC1A entity = new ExcIEEEDC1A();
    entity.setExcIEEEDC1AId(event.getExcIEEEDC1AId());
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
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event DeleteExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEDC1AEvent.class)
  public void handle(DeleteExcIEEEDC1AEvent event) {
    LOGGER.info("handling DeleteExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEDC1A entity = delete(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignEfd1ToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcIEEEDC1AEvent.class)
  public void handle(AssignEfd1ToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignEfd1ToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignEfd1(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcIEEEDC1AEvent.class)
  public void handle(UnAssignEfd1FromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignEfd1(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignEfd2ToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcIEEEDC1AEvent.class)
  public void handle(AssignEfd2ToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignEfd2ToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignEfd2(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcIEEEDC1AEvent.class)
  public void handle(UnAssignEfd2FromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignEfd2(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignExclimToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignExclimToExcIEEEDC1AEvent.class)
  public void handle(AssignExclimToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignExclimToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignExclim(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignExclimFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignExclimFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignExclimFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignExclimFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignExclim(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEDC1AEvent.class)
  public void handle(AssignKaToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignKa(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignKaFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignKa(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEDC1AEvent.class)
  public void handle(AssignKeToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignKe(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignKeFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignKe(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEDC1AEvent.class)
  public void handle(AssignKfToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignKf(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignKfFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignKf(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcIEEEDC1AEvent.class)
  public void handle(AssignSeefd1ToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignSeefd1(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcIEEEDC1AEvent.class)
  public void handle(UnAssignSeefd1FromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignSeefd1(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcIEEEDC1AEvent.class)
  public void handle(AssignSeefd2ToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignSeefd2(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcIEEEDC1AEvent.class)
  public void handle(UnAssignSeefd2FromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignSeefd2(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEDC1AEvent.class)
  public void handle(AssignTaToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignTa(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignTaFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignTa(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignTbToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignTbToExcIEEEDC1AEvent.class)
  public void handle(AssignTbToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignTbToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignTb(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignTbFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTbFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignTbFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignTbFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignTb(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignTcToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignTcToExcIEEEDC1AEvent.class)
  public void handle(AssignTcToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignTcToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignTc(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignTcFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTcFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignTcFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignTcFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignTc(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEDC1AEvent.class)
  public void handle(AssignTeToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignTe(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignTeFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignTe(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEDC1AEvent.class)
  public void handle(AssignTfToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignTf(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignTfFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignTf(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignUelinToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignUelinToExcIEEEDC1AEvent.class)
  public void handle(AssignUelinToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignUelinToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignUelin(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignUelinFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignUelinFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignUelinFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignUelinFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignUelin(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEDC1AEvent.class)
  public void handle(AssignVrmaxToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignVrmax(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignVrmax(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEDC1AEvent.class)
  public void handle(AssignVrminToExcIEEEDC1AEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC1A entity = assignVrmin(event.getExcIEEEDC1AId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEDC1AEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEDC1AEvent.class)
  public void handle(UnAssignVrminFromExcIEEEDC1AEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEDC1AEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC1A entity = unAssignVrmin(event.getExcIEEEDC1AId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC1A(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC1A(entity);
  }

  /**
   * Method to retrieve the ExcIEEEDC1A via an ExcIEEEDC1APrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEDC1A
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEDC1A handle(FindExcIEEEDC1AQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEDC1AId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC1As
   *
   * @param query FindAllExcIEEEDC1AQuery
   * @return List<ExcIEEEDC1A>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEDC1A> handle(FindAllExcIEEEDC1AQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEDC1A, but only if the id matches
   *
   * @param entity ExcIEEEDC1A
   */
  protected void emitFindExcIEEEDC1A(ExcIEEEDC1A entity) {
    LOGGER.info("handling emitFindExcIEEEDC1A");

    queryUpdateEmitter.emit(
        FindExcIEEEDC1AQuery.class,
        query -> query.getFilter().getExcIEEEDC1AId().equals(entity.getExcIEEEDC1AId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEDC1A
   *
   * @param entity ExcIEEEDC1A
   */
  protected void emitFindAllExcIEEEDC1A(ExcIEEEDC1A entity) {
    LOGGER.info("handling emitFindAllExcIEEEDC1A");

    queryUpdateEmitter.emit(FindAllExcIEEEDC1AQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC1AProjector.class.getName());
}
