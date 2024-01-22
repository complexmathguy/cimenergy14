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
 * Projector for ExcIEEEDC4B as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcIEEEDC4B are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcIEEEDC4BAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excIEEEDC4B")
@Component("excIEEEDC4B-projector")
public class ExcIEEEDC4BProjector extends ExcIEEEDC4BEntityProjector {

  // core constructor
  public ExcIEEEDC4BProjector(
      ExcIEEEDC4BRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = CreateExcIEEEDC4BEvent.class)
  public void handle(CreateExcIEEEDC4BEvent event) {
    LOGGER.info("handling CreateExcIEEEDC4BEvent - " + event);
    ExcIEEEDC4B entity = new ExcIEEEDC4B();
    entity.setExcIEEEDC4BId(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UpdateExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UpdateExcIEEEDC4BEvent.class)
  public void handle(UpdateExcIEEEDC4BEvent event) {
    LOGGER.info("handling UpdateExcIEEEDC4BEvent - " + event);

    ExcIEEEDC4B entity = new ExcIEEEDC4B();
    entity.setExcIEEEDC4BId(event.getExcIEEEDC4BId());
    entity.setEfd1(event.getEfd1());
    entity.setEfd2(event.getEfd2());
    entity.setKa(event.getKa());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKf(event.getKf());
    entity.setKi(event.getKi());
    entity.setKp(event.getKp());
    entity.setOelin(event.getOelin());
    entity.setSeefd1(event.getSeefd1());
    entity.setSeefd2(event.getSeefd2());
    entity.setTa(event.getTa());
    entity.setTd(event.getTd());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setUelin(event.getUelin());
    entity.setVemin(event.getVemin());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event DeleteExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = DeleteExcIEEEDC4BEvent.class)
  public void handle(DeleteExcIEEEDC4BEvent event) {
    LOGGER.info("handling DeleteExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcIEEEDC4B entity = delete(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignEfd1ToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignEfd1ToExcIEEEDC4BEvent.class)
  public void handle(AssignEfd1ToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignEfd1ToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignEfd1(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignEfd1FromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignEfd1FromExcIEEEDC4BEvent.class)
  public void handle(UnAssignEfd1FromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignEfd1FromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignEfd1(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignEfd2ToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignEfd2ToExcIEEEDC4BEvent.class)
  public void handle(AssignEfd2ToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignEfd2ToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignEfd2(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignEfd2FromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignEfd2FromExcIEEEDC4BEvent.class)
  public void handle(UnAssignEfd2FromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignEfd2FromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignEfd2(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignKaToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignKaToExcIEEEDC4BEvent.class)
  public void handle(AssignKaToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignKaToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignKa(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignKaFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignKaFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignKaFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignKaFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignKa(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignKdToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignKdToExcIEEEDC4BEvent.class)
  public void handle(AssignKdToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignKdToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignKd(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignKdFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignKdFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignKdFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignKd(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignKeToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignKeToExcIEEEDC4BEvent.class)
  public void handle(AssignKeToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignKeToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignKe(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignKeFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignKeFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignKeFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignKe(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignKfToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignKfToExcIEEEDC4BEvent.class)
  public void handle(AssignKfToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignKfToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignKf(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignKfFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignKfFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignKfFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignKf(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignKiToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignKiToExcIEEEDC4BEvent.class)
  public void handle(AssignKiToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignKiToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignKi(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignKiFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignKiFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignKiFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignKiFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignKi(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignKpToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignKpToExcIEEEDC4BEvent.class)
  public void handle(AssignKpToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignKpToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignKp(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignKpFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignKpFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignKpFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignKpFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignKp(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignOelinToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignOelinToExcIEEEDC4BEvent.class)
  public void handle(AssignOelinToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignOelinToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignOelin(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignOelinFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignOelinFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignOelinFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignOelinFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignOelin(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignSeefd1ToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignSeefd1ToExcIEEEDC4BEvent.class)
  public void handle(AssignSeefd1ToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignSeefd1ToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignSeefd1(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignSeefd1FromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignSeefd1FromExcIEEEDC4BEvent.class)
  public void handle(UnAssignSeefd1FromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignSeefd1FromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignSeefd1(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignSeefd2ToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignSeefd2ToExcIEEEDC4BEvent.class)
  public void handle(AssignSeefd2ToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignSeefd2ToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignSeefd2(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignSeefd2FromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignSeefd2FromExcIEEEDC4BEvent.class)
  public void handle(UnAssignSeefd2FromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignSeefd2FromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignSeefd2(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignTaToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignTaToExcIEEEDC4BEvent.class)
  public void handle(AssignTaToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignTaToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignTa(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignTaFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignTaFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignTaFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignTa(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignTdToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignTdToExcIEEEDC4BEvent.class)
  public void handle(AssignTdToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignTdToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignTd(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignTdFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignTdFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignTdFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignTdFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignTd(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignTeToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignTeToExcIEEEDC4BEvent.class)
  public void handle(AssignTeToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignTeToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignTe(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignTeFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignTeFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignTeFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignTe(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignTfToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignTfToExcIEEEDC4BEvent.class)
  public void handle(AssignTfToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignTfToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignTf(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignTfFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignTfFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignTfFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignTf(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignUelinToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignUelinToExcIEEEDC4BEvent.class)
  public void handle(AssignUelinToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignUelinToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignUelin(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignUelinFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignUelinFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignUelinFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignUelinFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignUelin(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignVeminToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignVeminToExcIEEEDC4BEvent.class)
  public void handle(AssignVeminToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignVeminToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignVemin(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignVeminFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignVeminFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignVeminFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignVeminFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignVemin(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignVrmaxToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcIEEEDC4BEvent.class)
  public void handle(AssignVrmaxToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignVrmaxToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignVrmax(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignVrmaxFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignVrmax(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event AssignVrminToExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = AssignVrminToExcIEEEDC4BEvent.class)
  public void handle(AssignVrminToExcIEEEDC4BEvent event) {
    LOGGER.info("handling AssignVrminToExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcIEEEDC4B entity = assignVrmin(event.getExcIEEEDC4BId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcIEEEDC4BEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcIEEEDC4BEvent.class)
  public void handle(UnAssignVrminFromExcIEEEDC4BEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcIEEEDC4BEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcIEEEDC4B entity = unAssignVrmin(event.getExcIEEEDC4BId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcIEEEDC4B(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcIEEEDC4B(entity);
  }

  /**
   * Method to retrieve the ExcIEEEDC4B via an ExcIEEEDC4BPrimaryKey.
   *
   * @param id Long
   * @return ExcIEEEDC4B
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcIEEEDC4B handle(FindExcIEEEDC4BQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcIEEEDC4BId());
  }

  /**
   * Method to retrieve a collection of all ExcIEEEDC4Bs
   *
   * @param query FindAllExcIEEEDC4BQuery
   * @return List<ExcIEEEDC4B>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcIEEEDC4B> handle(FindAllExcIEEEDC4BQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcIEEEDC4B, but only if the id matches
   *
   * @param entity ExcIEEEDC4B
   */
  protected void emitFindExcIEEEDC4B(ExcIEEEDC4B entity) {
    LOGGER.info("handling emitFindExcIEEEDC4B");

    queryUpdateEmitter.emit(
        FindExcIEEEDC4BQuery.class,
        query -> query.getFilter().getExcIEEEDC4BId().equals(entity.getExcIEEEDC4BId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcIEEEDC4B
   *
   * @param entity ExcIEEEDC4B
   */
  protected void emitFindAllExcIEEEDC4B(ExcIEEEDC4B entity) {
    LOGGER.info("handling emitFindAllExcIEEEDC4B");

    queryUpdateEmitter.emit(FindAllExcIEEEDC4BQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcIEEEDC4BProjector.class.getName());
}
