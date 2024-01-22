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
 * Projector for ExcREXS as outlined for the CQRS pattern. All event handling and query handling
 * related to ExcREXS are invoked here and dispersed as an event to be handled elsewhere.
 *
 * <p>Commands are handled by ExcREXSAggregate
 *
 * @author your_name_here
 */
// @ProcessingGroup("excREXS")
@Component("excREXS-projector")
public class ExcREXSProjector extends ExcREXSEntityProjector {

  // core constructor
  public ExcREXSProjector(ExcREXSRepository repository, QueryUpdateEmitter queryUpdateEmitter) {
    super(repository);
    this.queryUpdateEmitter = queryUpdateEmitter;
  }

  /*
   * @param	event CreateExcREXSEvent
   */
  @EventHandler(payloadType = CreateExcREXSEvent.class)
  public void handle(CreateExcREXSEvent event) {
    LOGGER.info("handling CreateExcREXSEvent - " + event);
    ExcREXS entity = new ExcREXS();
    entity.setExcREXSId(event.getExcREXSId());
    entity.setFbf(event.getFbf());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    create(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UpdateExcREXSEvent
   */
  @EventHandler(payloadType = UpdateExcREXSEvent.class)
  public void handle(UpdateExcREXSEvent event) {
    LOGGER.info("handling UpdateExcREXSEvent - " + event);

    ExcREXS entity = new ExcREXS();
    entity.setExcREXSId(event.getExcREXSId());
    entity.setE1(event.getE1());
    entity.setE2(event.getE2());
    entity.setFbf(event.getFbf());
    entity.setFlimf(event.getFlimf());
    entity.setKc(event.getKc());
    entity.setKd(event.getKd());
    entity.setKe(event.getKe());
    entity.setKefd(event.getKefd());
    entity.setKf(event.getKf());
    entity.setKh(event.getKh());
    entity.setKii(event.getKii());
    entity.setKip(event.getKip());
    entity.setKs(event.getKs());
    entity.setKvi(event.getKvi());
    entity.setKvp(event.getKvp());
    entity.setKvphz(event.getKvphz());
    entity.setNvphz(event.getNvphz());
    entity.setSe1(event.getSe1());
    entity.setSe2(event.getSe2());
    entity.setTa(event.getTa());
    entity.setTb1(event.getTb1());
    entity.setTb2(event.getTb2());
    entity.setTc1(event.getTc1());
    entity.setTc2(event.getTc2());
    entity.setTe(event.getTe());
    entity.setTf(event.getTf());
    entity.setTf1(event.getTf1());
    entity.setTf2(event.getTf2());
    entity.setTp(event.getTp());
    entity.setVcmax(event.getVcmax());
    entity.setVfmax(event.getVfmax());
    entity.setVfmin(event.getVfmin());
    entity.setVimax(event.getVimax());
    entity.setVrmax(event.getVrmax());
    entity.setVrmin(event.getVrmin());
    entity.setXc(event.getXc());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    update(entity);

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event DeleteExcREXSEvent
   */
  @EventHandler(payloadType = DeleteExcREXSEvent.class)
  public void handle(DeleteExcREXSEvent event) {
    LOGGER.info("handling DeleteExcREXSEvent - " + event);

    // ------------------------------------------
    // delete delegation
    // ------------------------------------------
    ExcREXS entity = delete(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignE1ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignE1ToExcREXSEvent.class)
  public void handle(AssignE1ToExcREXSEvent event) {
    LOGGER.info("handling AssignE1ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignE1(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignE1FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignE1FromExcREXSEvent.class)
  public void handle(UnAssignE1FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignE1FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignE1(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignE2ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignE2ToExcREXSEvent.class)
  public void handle(AssignE2ToExcREXSEvent event) {
    LOGGER.info("handling AssignE2ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignE2(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignE2FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignE2FromExcREXSEvent.class)
  public void handle(UnAssignE2FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignE2FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignE2(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignFlimfToExcREXSEvent
   */
  @EventHandler(payloadType = AssignFlimfToExcREXSEvent.class)
  public void handle(AssignFlimfToExcREXSEvent event) {
    LOGGER.info("handling AssignFlimfToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignFlimf(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignFlimfFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignFlimfFromExcREXSEvent.class)
  public void handle(UnAssignFlimfFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignFlimfFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignFlimf(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKcToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKcToExcREXSEvent.class)
  public void handle(AssignKcToExcREXSEvent event) {
    LOGGER.info("handling AssignKcToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKc(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKcFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKcFromExcREXSEvent.class)
  public void handle(UnAssignKcFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKcFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKc(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKdToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKdToExcREXSEvent.class)
  public void handle(AssignKdToExcREXSEvent event) {
    LOGGER.info("handling AssignKdToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKd(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKdFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKdFromExcREXSEvent.class)
  public void handle(UnAssignKdFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKdFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKd(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKeToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKeToExcREXSEvent.class)
  public void handle(AssignKeToExcREXSEvent event) {
    LOGGER.info("handling AssignKeToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKe(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKeFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKeFromExcREXSEvent.class)
  public void handle(UnAssignKeFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKeFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKe(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKefdToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKefdToExcREXSEvent.class)
  public void handle(AssignKefdToExcREXSEvent event) {
    LOGGER.info("handling AssignKefdToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKefd(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKefdFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKefdFromExcREXSEvent.class)
  public void handle(UnAssignKefdFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKefdFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKefd(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKfToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKfToExcREXSEvent.class)
  public void handle(AssignKfToExcREXSEvent event) {
    LOGGER.info("handling AssignKfToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKf(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKfFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKfFromExcREXSEvent.class)
  public void handle(UnAssignKfFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKfFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKf(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKhToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKhToExcREXSEvent.class)
  public void handle(AssignKhToExcREXSEvent event) {
    LOGGER.info("handling AssignKhToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKh(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKhFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKhFromExcREXSEvent.class)
  public void handle(UnAssignKhFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKhFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKh(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKiiToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKiiToExcREXSEvent.class)
  public void handle(AssignKiiToExcREXSEvent event) {
    LOGGER.info("handling AssignKiiToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKii(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKiiFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKiiFromExcREXSEvent.class)
  public void handle(UnAssignKiiFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKiiFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKii(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKipToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKipToExcREXSEvent.class)
  public void handle(AssignKipToExcREXSEvent event) {
    LOGGER.info("handling AssignKipToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKip(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKipFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKipFromExcREXSEvent.class)
  public void handle(UnAssignKipFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKipFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKip(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKsToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKsToExcREXSEvent.class)
  public void handle(AssignKsToExcREXSEvent event) {
    LOGGER.info("handling AssignKsToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKs(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKsFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKsFromExcREXSEvent.class)
  public void handle(UnAssignKsFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKsFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKs(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKviToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKviToExcREXSEvent.class)
  public void handle(AssignKviToExcREXSEvent event) {
    LOGGER.info("handling AssignKviToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKvi(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKviFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKviFromExcREXSEvent.class)
  public void handle(UnAssignKviFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKviFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKvi(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKvpToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKvpToExcREXSEvent.class)
  public void handle(AssignKvpToExcREXSEvent event) {
    LOGGER.info("handling AssignKvpToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKvp(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKvpFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKvpFromExcREXSEvent.class)
  public void handle(UnAssignKvpFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKvpFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKvp(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignKvphzToExcREXSEvent
   */
  @EventHandler(payloadType = AssignKvphzToExcREXSEvent.class)
  public void handle(AssignKvphzToExcREXSEvent event) {
    LOGGER.info("handling AssignKvphzToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignKvphz(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignKvphzFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignKvphzFromExcREXSEvent.class)
  public void handle(UnAssignKvphzFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignKvphzFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignKvphz(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignNvphzToExcREXSEvent
   */
  @EventHandler(payloadType = AssignNvphzToExcREXSEvent.class)
  public void handle(AssignNvphzToExcREXSEvent event) {
    LOGGER.info("handling AssignNvphzToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignNvphz(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignNvphzFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignNvphzFromExcREXSEvent.class)
  public void handle(UnAssignNvphzFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignNvphzFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignNvphz(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignSe1ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignSe1ToExcREXSEvent.class)
  public void handle(AssignSe1ToExcREXSEvent event) {
    LOGGER.info("handling AssignSe1ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignSe1(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignSe1FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignSe1FromExcREXSEvent.class)
  public void handle(UnAssignSe1FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignSe1FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignSe1(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignSe2ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignSe2ToExcREXSEvent.class)
  public void handle(AssignSe2ToExcREXSEvent event) {
    LOGGER.info("handling AssignSe2ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignSe2(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignSe2FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignSe2FromExcREXSEvent.class)
  public void handle(UnAssignSe2FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignSe2FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignSe2(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTaToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTaToExcREXSEvent.class)
  public void handle(AssignTaToExcREXSEvent event) {
    LOGGER.info("handling AssignTaToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTa(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTaFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTaFromExcREXSEvent.class)
  public void handle(UnAssignTaFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTaFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTa(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTb1ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTb1ToExcREXSEvent.class)
  public void handle(AssignTb1ToExcREXSEvent event) {
    LOGGER.info("handling AssignTb1ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTb1(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTb1FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTb1FromExcREXSEvent.class)
  public void handle(UnAssignTb1FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTb1FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTb1(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTb2ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTb2ToExcREXSEvent.class)
  public void handle(AssignTb2ToExcREXSEvent event) {
    LOGGER.info("handling AssignTb2ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTb2(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTb2FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTb2FromExcREXSEvent.class)
  public void handle(UnAssignTb2FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTb2FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTb2(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTc1ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTc1ToExcREXSEvent.class)
  public void handle(AssignTc1ToExcREXSEvent event) {
    LOGGER.info("handling AssignTc1ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTc1(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTc1FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTc1FromExcREXSEvent.class)
  public void handle(UnAssignTc1FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTc1FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTc1(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTc2ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTc2ToExcREXSEvent.class)
  public void handle(AssignTc2ToExcREXSEvent event) {
    LOGGER.info("handling AssignTc2ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTc2(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTc2FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTc2FromExcREXSEvent.class)
  public void handle(UnAssignTc2FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTc2FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTc2(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTeToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTeToExcREXSEvent.class)
  public void handle(AssignTeToExcREXSEvent event) {
    LOGGER.info("handling AssignTeToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTe(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTeFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTeFromExcREXSEvent.class)
  public void handle(UnAssignTeFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTeFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTe(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTfToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTfToExcREXSEvent.class)
  public void handle(AssignTfToExcREXSEvent event) {
    LOGGER.info("handling AssignTfToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTf(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTfFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTfFromExcREXSEvent.class)
  public void handle(UnAssignTfFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTfFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTf(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTf1ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTf1ToExcREXSEvent.class)
  public void handle(AssignTf1ToExcREXSEvent event) {
    LOGGER.info("handling AssignTf1ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTf1(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTf1FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTf1FromExcREXSEvent.class)
  public void handle(UnAssignTf1FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTf1FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTf1(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTf2ToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTf2ToExcREXSEvent.class)
  public void handle(AssignTf2ToExcREXSEvent event) {
    LOGGER.info("handling AssignTf2ToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTf2(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTf2FromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTf2FromExcREXSEvent.class)
  public void handle(UnAssignTf2FromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTf2FromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTf2(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignTpToExcREXSEvent
   */
  @EventHandler(payloadType = AssignTpToExcREXSEvent.class)
  public void handle(AssignTpToExcREXSEvent event) {
    LOGGER.info("handling AssignTpToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignTp(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignTpFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignTpFromExcREXSEvent.class)
  public void handle(UnAssignTpFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignTpFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignTp(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignVcmaxToExcREXSEvent
   */
  @EventHandler(payloadType = AssignVcmaxToExcREXSEvent.class)
  public void handle(AssignVcmaxToExcREXSEvent event) {
    LOGGER.info("handling AssignVcmaxToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignVcmax(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignVcmaxFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignVcmaxFromExcREXSEvent.class)
  public void handle(UnAssignVcmaxFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignVcmaxFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignVcmax(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignVfmaxToExcREXSEvent
   */
  @EventHandler(payloadType = AssignVfmaxToExcREXSEvent.class)
  public void handle(AssignVfmaxToExcREXSEvent event) {
    LOGGER.info("handling AssignVfmaxToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignVfmax(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignVfmaxFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignVfmaxFromExcREXSEvent.class)
  public void handle(UnAssignVfmaxFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignVfmaxFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignVfmax(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignVfminToExcREXSEvent
   */
  @EventHandler(payloadType = AssignVfminToExcREXSEvent.class)
  public void handle(AssignVfminToExcREXSEvent event) {
    LOGGER.info("handling AssignVfminToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignVfmin(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignVfminFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignVfminFromExcREXSEvent.class)
  public void handle(UnAssignVfminFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignVfminFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignVfmin(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignVimaxToExcREXSEvent
   */
  @EventHandler(payloadType = AssignVimaxToExcREXSEvent.class)
  public void handle(AssignVimaxToExcREXSEvent event) {
    LOGGER.info("handling AssignVimaxToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignVimax(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignVimaxFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignVimaxFromExcREXSEvent.class)
  public void handle(UnAssignVimaxFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignVimaxFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignVimax(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignVrmaxToExcREXSEvent
   */
  @EventHandler(payloadType = AssignVrmaxToExcREXSEvent.class)
  public void handle(AssignVrmaxToExcREXSEvent event) {
    LOGGER.info("handling AssignVrmaxToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignVrmax(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignVrmaxFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignVrmaxFromExcREXSEvent.class)
  public void handle(UnAssignVrmaxFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignVrmaxFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignVrmax(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignVrminToExcREXSEvent
   */
  @EventHandler(payloadType = AssignVrminToExcREXSEvent.class)
  public void handle(AssignVrminToExcREXSEvent event) {
    LOGGER.info("handling AssignVrminToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignVrmin(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignVrminFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignVrminFromExcREXSEvent.class)
  public void handle(UnAssignVrminFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignVrminFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignVrmin(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event AssignXcToExcREXSEvent
   */
  @EventHandler(payloadType = AssignXcToExcREXSEvent.class)
  public void handle(AssignXcToExcREXSEvent event) {
    LOGGER.info("handling AssignXcToExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to assignTo
    // ------------------------------------------
    ExcREXS entity = assignXc(event.getExcREXSId(), event.getAssignment());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /*
   * @param	event UnAssignXcFromExcREXSEvent
   */
  @EventHandler(payloadType = UnAssignXcFromExcREXSEvent.class)
  public void handle(UnAssignXcFromExcREXSEvent event) {
    LOGGER.info("handling UnAssignXcFromExcREXSEvent - " + event);

    // ------------------------------------------
    // delegate to unAssignFrom
    // ------------------------------------------
    ExcREXS entity = unAssignXc(event.getExcREXSId());

    // ------------------------------------------
    // emit to subscribers that find one
    // ------------------------------------------
    emitFindExcREXS(entity);

    // ------------------------------------------
    // emit to subscribers that find all
    // ------------------------------------------
    emitFindAllExcREXS(entity);
  }

  /**
   * Method to retrieve the ExcREXS via an ExcREXSPrimaryKey.
   *
   * @param id Long
   * @return ExcREXS
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public ExcREXS handle(FindExcREXSQuery query)
      throws ProcessingException, IllegalArgumentException {
    return find(query.getFilter().getExcREXSId());
  }

  /**
   * Method to retrieve a collection of all ExcREXSs
   *
   * @param query FindAllExcREXSQuery
   * @return List<ExcREXS>
   * @exception ProcessingException Thrown if any problems
   */
  @SuppressWarnings("unused")
  @QueryHandler
  public List<ExcREXS> handle(FindAllExcREXSQuery query) throws ProcessingException {
    return findAll(query);
  }

  /**
   * emit to subscription queries of type FindExcREXS, but only if the id matches
   *
   * @param entity ExcREXS
   */
  protected void emitFindExcREXS(ExcREXS entity) {
    LOGGER.info("handling emitFindExcREXS");

    queryUpdateEmitter.emit(
        FindExcREXSQuery.class,
        query -> query.getFilter().getExcREXSId().equals(entity.getExcREXSId()),
        entity);
  }

  /**
   * unconditionally emit to subscription queries of type FindAllExcREXS
   *
   * @param entity ExcREXS
   */
  protected void emitFindAllExcREXS(ExcREXS entity) {
    LOGGER.info("handling emitFindAllExcREXS");

    queryUpdateEmitter.emit(FindAllExcREXSQuery.class, query -> true, entity);
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired private final QueryUpdateEmitter queryUpdateEmitter;
  private static final Logger LOGGER = Logger.getLogger(ExcREXSProjector.class.getName());
}
