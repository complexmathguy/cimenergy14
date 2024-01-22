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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate;

import com.occulue.api.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator.*;
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
 * Discrete business delegate class.
 *
 * <p>This class implements the Business Delegate design pattern for the purpose of:
 *
 * <ol>
 *   <li>Reducing coupling between the business tier and a client of the business tier by hiding all
 *       business-tier implementation details
 *   <li>Improving the available of Discrete related services in the case of a Discrete business
 *       related service failing.
 *   <li>Exposes a simpler, uniform Discrete interface to the business tier, making it easy for
 *       clients to consume a simple Java object.
 *   <li>Hides the communication protocol that may be required to fulfill Discrete business related
 *       services.
 * </ol>
 *
 * <p>
 *
 * @author your_name_here
 */
public class DiscreteBusinessDelegate extends BaseBusinessDelegate {
  // ************************************************************************
  // Public Methods
  // ************************************************************************
  /** Default Constructor */
  public DiscreteBusinessDelegate() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
    commandGateway = applicationContext.getBean(CommandGateway.class);
    queryUpdateEmitter = applicationContext.getBean(QueryUpdateEmitter.class);
  }

  /**
   * Discrete Business Delegate Factory Method
   *
   * <p>All methods are expected to be self-sufficient.
   *
   * @return DiscreteBusinessDelegate
   */
  public static DiscreteBusinessDelegate getDiscreteInstance() {
    return (new DiscreteBusinessDelegate());
  }

  /**
   * Creates the provided command.
   *
   * @param command ${class.getCreateCommandAlias()}
   * @exception ProcessingException
   * @exception IllegalArgumentException
   * @return CompletableFuture<UUID>
   */
  public CompletableFuture<UUID> createDiscrete(CreateDiscreteCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<UUID> completableFuture = null;

    try {
      // --------------------------------------
      // assign identity now if none
      // --------------------------------------
      if (command.getDiscreteId() == null) command.setDiscreteId(UUID.randomUUID());

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValidator.getInstance().validate(command);

      // ---------------------------------------
      // issue the CreateDiscreteCommand - by convention the future return value for a create
      // command
      // that is handled by the constructor of an aggregate will return the UUID
      // ---------------------------------------
      completableFuture = commandGateway.send(command);

      LOGGER.log(
          Level.INFO,
          "return from Command Gateway for CreateDiscreteCommand of Discrete is " + command);

    } catch (Exception exc) {
      final String errMsg = "Unable to create Discrete - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Update the provided command.
   *
   * @param command UpdateDiscreteCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   * @exception IllegalArgumentException
   */
  public CompletableFuture<Void> updateDiscrete(UpdateDiscreteCommand command)
      throws ProcessingException, IllegalArgumentException {
    CompletableFuture<Void> completableFuture = null;

    try {

      // --------------------------------------
      // validate
      // --------------------------------------
      DiscreteValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the UpdateDiscreteCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to save Discrete - " + exc;
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    }

    return completableFuture;
  }

  /**
   * Deletes the associatied value object
   *
   * @param command DeleteDiscreteCommand
   * @return CompletableFuture<Void>
   * @exception ProcessingException
   */
  public CompletableFuture<Void> delete(DeleteDiscreteCommand command)
      throws ProcessingException, IllegalArgumentException {

    CompletableFuture<Void> completableFuture = null;

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the DeleteDiscreteCommand and return right away
      // --------------------------------------
      completableFuture = commandGateway.send(command);
    } catch (Exception exc) {
      final String errMsg = "Unable to delete Discrete using Id = " + command.getDiscreteId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return completableFuture;
  }

  /**
   * Method to retrieve the Discrete via DiscreteFetchOneSummary
   *
   * @param summary DiscreteFetchOneSummary
   * @return DiscreteFetchOneResponse
   * @exception ProcessingException - Thrown if processing any related problems
   * @exception IllegalArgumentException
   */
  public Discrete getDiscrete(DiscreteFetchOneSummary summary)
      throws ProcessingException, IllegalArgumentException {

    if (summary == null)
      throw new IllegalArgumentException("DiscreteFetchOneSummary arg cannot be null");

    Discrete entity = null;

    try {
      // --------------------------------------
      // validate the fetch one summary
      // --------------------------------------
      DiscreteValidator.getInstance().validate(summary);

      // --------------------------------------
      // use queryGateway to send request to Find a Discrete
      // --------------------------------------
      CompletableFuture<Discrete> futureEntity =
          queryGateway.query(
              new FindDiscreteQuery(new LoadDiscreteFilter(summary.getDiscreteId())),
              ResponseTypes.instanceOf(Discrete.class));

      entity = futureEntity.get();
    } catch (Exception exc) {
      final String errMsg = "Unable to locate Discrete with id " + summary.getDiscreteId();
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return entity;
  }

  /**
   * Method to retrieve a collection of all Discretes
   *
   * @return List<Discrete>
   * @exception ProcessingException Thrown if any problems
   */
  public List<Discrete> getAllDiscrete() throws ProcessingException {
    List<Discrete> list = null;

    try {
      CompletableFuture<List<Discrete>> futureList =
          queryGateway.query(
              new FindAllDiscreteQuery(), ResponseTypes.multipleInstancesOf(Discrete.class));

      list = futureList.get();
    } catch (Exception exc) {
      String errMsg = "Failed to get all Discrete";
      LOGGER.log(Level.WARNING, errMsg, exc);
      throw new ProcessingException(errMsg, exc);
    } finally {
    }

    return list;
  }

  /**
   * add Discrete to Discretes
   *
   * @param command AssignDiscretesToDiscreteCommand
   * @exception ProcessingException
   */
  public void addToDiscretes(AssignDiscretesToDiscreteCommand command) throws ProcessingException {

    // -------------------------------------------
    // load the parent
    // -------------------------------------------
    load(command.getDiscreteId());

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .DiscreteBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.DiscreteBusinessDelegate.getDiscreteInstance();
    DiscreteBusinessDelegate parentDelegate = DiscreteBusinessDelegate.getDiscreteInstance();
    UUID childId = command.getAddTo().getDiscreteId();

    try {
      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValidator.getInstance().validate(command);

      // --------------------------------------
      // issue the command
      // --------------------------------------
      commandGateway.sendAndWait(command);
    } catch (Exception exc) {
      final String msg = "Failed to add a Discrete as Discretes to Discrete";
      LOGGER.log(Level.WARNING, msg, exc);
      throw new ProcessingException(msg, exc);
    }
  }

  /**
   * remove Discrete from Discretes
   *
   * @param command RemoveDiscretesFromDiscreteCommand
   * @exception ProcessingException
   */
  public void removeFromDiscretes(RemoveDiscretesFromDiscreteCommand command)
      throws ProcessingException {

    com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.delegate
            .DiscreteBusinessDelegate
        childDelegate =
            com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas
                .delegate.DiscreteBusinessDelegate.getDiscreteInstance();
    UUID childId = command.getRemoveFrom().getDiscreteId();

    try {

      // --------------------------------------
      // validate the command
      // --------------------------------------
      DiscreteValidator.getInstance().validate(command);

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
   * @return Discrete
   */
  private Discrete load(UUID id) throws ProcessingException {
    discrete =
        DiscreteBusinessDelegate.getDiscreteInstance().getDiscrete(new DiscreteFetchOneSummary(id));
    return discrete;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  private final QueryGateway queryGateway;
  private final CommandGateway commandGateway;
  private final QueryUpdateEmitter queryUpdateEmitter;
  private Discrete discrete = null;
  private static final Logger LOGGER = Logger.getLogger(DiscreteBusinessDelegate.class.getName());
}
