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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.validator.*;
import com.occulue.exception.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryUpdateEmitter;

/**
 * EnergySource business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of EnergySource related services in the case of a EnergySource
 *       business related service failing.
 *   <li>Exposes a simpler, uniform EnergySource interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill EnergySource business
 *       related services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class EnergySourceBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public EnergySourceBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * EnergySource Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return EnergySourceBusinessDelegate
   */
  public static EnergySourceBusinessDelegate getEnergySourceInstance() {
    return (new EnergySourceBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createEnergySource(CreateEnergySourceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getEnergySourceId() == null) command.setEnergySourceId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergySourceValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateEnergySourceCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateEnergySourceCommand of EnergySource is "
              + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create EnergySource - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateEnergySourceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateEnergySource(UpdateEnergySourceCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      EnergySourceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateEnergySourceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save EnergySource - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteEnergySourceCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteEnergySourceCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergySourceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteEnergySourceCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg =
          "Unable to delete EnergySource using Id = " + command.getEnergySourceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the EnergySource via EnergySourceFetchOneSummary
   *
   * @param summary EnergySourceFetchOneSummary
   * @return EnergySourceFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public EnergySource getEnergySource(EnergySourceFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("EnergySourceFetchOneSummary arg cannot be null");

    EnergySource entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      EnergySourceValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a EnergySource
      // --------------------------------------
      CompletableFuture<EnergySource> futureEntity =
          queryGateway.query(
              new FindEnergySourceQuery(new LoadEnergySourceFilter(summary.getEnergySourceId())),
              ResponseTypes.instanceOf(EnergySource.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate EnergySource with id " + summary.getEnergySourceId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all EnergySources
   *
   * @return List<EnergySource>
   * @exception ProcessingException Thrown if any problems
   */
  public List<EnergySource> getAllEnergySource() throws ProcessingException {
    List<EnergySource> list = null;

    try {
      CompletableFuture<List<EnergySource>> futureList =
          queryGateway.query(
              new FindAllEnergySourceQuery(),
              ResponseTypes.multipleInstancesOf(EnergySource.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all EnergySource";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add EnergySource to EnergySource
   *
   * @param command AssignEnergySourceToEnergySourceCommand
   * @exception ProcessingException
   */
  public void addToEnergySource(AssignEnergySourceToEnergySourceCommand command)
      throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getEnergySourceId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires
            .delegate.EnergySourceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .wires.delegate.EnergySourceBusinessDelegate.getEnergySourceInstance();
    EnergySourceBusinessDelegate parentDelegate =
        EnergySourceBusinessDelegate.getEnergySourceInstance();
    UUID childId = command.getAddTo().getEnergySourceId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergySourceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a EnergySource as EnergySource to EnergySource";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove EnergySource from EnergySource
   *
   * @param command RemoveEnergySourceFromEnergySourceCommand
   * @exception ProcessingException
   */
  public void removeFromEnergySource(RemoveEnergySourceFromEnergySourceCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires
            .delegate.EnergySourceBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile
                .wires.delegate.EnergySourceBusinessDelegate.getEnergySourceInstance();
    UUID childId = command.getRemoveFrom().getEnergySourceId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      EnergySourceValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);

    } catch (Exception exc) {
      final String msg = "Failed to remove child using Id " + childId;
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * Internal helper method to load the root
   *
   * @param id UUID
   * @return EnergySource
   */
  private EnergySource load(UUID id) throws ProcessingException {
    energySource =
        EnergySourceBusinessDelegate.getEnergySourceInstance()
            .getEnergySource(new EnergySourceFetchOneSummary(id));
    return energySource;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private EnergySource energySource = null;
  private static final Logger LOGGER =
      Logger.getLogger(EnergySourceBusinessDelegate.class.getName());
}
